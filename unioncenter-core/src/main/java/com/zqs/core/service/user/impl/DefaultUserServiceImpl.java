package com.zqs.core.service.user.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zqs.core.dao.other.IValidateCodeMapper;
import com.zqs.core.dao.user.IUserMapper;
import com.zqs.core.service.user.IUserService;
import com.zqs.core.utils.date.DateFormatUtils;
import com.zqs.core.utils.json.JacksonUtils;
import com.zqs.core.utils.string.StringUtils;
import com.zqs.pojo.base.ReturnObject;
import com.zqs.pojo.base.e.ReturnCode;
import com.zqs.pojo.other.ValidateCode;
import com.zqs.pojo.user.User;

public class DefaultUserServiceImpl implements IUserService {
	
	private Logger logger = LoggerFactory.getLogger(DefaultUserServiceImpl.class);
	
	@Autowired
	private IUserMapper userMapper;
	@Autowired
	private IValidateCodeMapper validateCodeMapper;
	
	@Override
	public String loadAll(Map<String, Object> map) {
		ReturnObject returnObject = new ReturnObject();
		String returnCode = ReturnCode.SUCCESS_CODE;
		String returnMsg = ReturnCode.SUCCESS_MSG;
		User user = new User();
		
		try{
			user = userMapper.loadAll(map);
		}catch(Exception e){
			logger.error("查询用户出错,[{}]",e);
			returnCode = ReturnCode.PROGRAM_ERROR_CODE;
			returnMsg = ReturnCode.PROGRAM_ERROR_MSG;
		}
		
		returnObject.setReturnCode(returnCode);
		returnObject.setReturnMsg(returnMsg);
		returnObject.setReturnObj(JacksonUtils.object2json(user));
		
		return JacksonUtils.object2json(returnObject);
	}

	@Override
	public String register(User user) {
		//初始化返回参数
		ReturnObject returnObject = new ReturnObject();
		String returnCode = ReturnCode.SUCCESS_CODE;
		String returnMsg = ReturnCode.SUCCESS_MSG;
		
		//1、验证参数是否完整
		if(user != null){
			//2、验证是否缺少参数
			if(!StringUtils.isEmpty(user.getUserName())
					&& !StringUtils.isEmpty(user.getMobile())
					&& !StringUtils.isEmpty(user.getPassword())
					&& !StringUtils.isEmpty(user.getPasswordAgain())
					&& !StringUtils.isEmpty(user.getMessageCode())
					&& !StringUtils.isEmpty(user.getImgCode())){
				//3、验证密码是否一致
				if(user.getPassword().equals(user.getPasswordAgain())){
					//4、验证图片验证码
					//5、验证短信验证码是否正确
					Map<String,Object> o = new HashMap<String,Object>();
					o.put("mobile", user.getMobile());
					o.put("type", 1);
					ValidateCode code = validateCodeMapper.loadAll(o);
					if(code != null && code.getId() != null){
						//6、验证验证码是否已过期
						if(code.getEndTime().after(new Date())){
							if(code.getCode().equals(user.getMessageCode())){
								//7、验证手机号是否已注册
								User u = new User();
								u.setMobile(user.getMobile());
								int indexM = userMapper.isUserExist(u);
								if(indexM == 0){
									//8、验证用户名是否存在
									u = new User();
									u.setUserName(user.getUserName());
									indexM = userMapper.isUserExist(u);
									if(indexM == 0){
										try{
											//注册
											user.setPassword(DigestUtils.md5Hex(user.getPassword()));
											user.setRegTime(new Date());
											userMapper.save(user);
											//短信验证码失效
											validateCodeMapper.update(code.getId());
										}catch(Exception e){
											logger.error("注册用户发生错误,[{}]",e);
											returnCode = ReturnCode.PROGRAM_ERROR_CODE;
											returnMsg = ReturnCode.PROGRAM_ERROR_MSG;
										}
									}else{
										returnCode = ReturnCode.NAME_EXSIT_CODE;
										returnMsg = ReturnCode.NAME_EXSIT_MSG;
									}
								}else{
									returnCode = ReturnCode.MOBILE_EXSIT_CODE;
									returnMsg = ReturnCode.MOBILE_EXSIT_MSG;
								}
							}else{
								returnCode = ReturnCode.VALIDATE_ERROR_CODE;
								returnMsg = ReturnCode.VALIDATE_ERROR_MSG;
							}
						}else{
							//验证码过期，更新状态
							validateCodeMapper.update(code.getId());
							returnCode = ReturnCode.MESSAGE_NO_SEND_CODE;
							returnMsg = ReturnCode.MESSAGE_NO_SEND_MSG;
						}
					}else{
						returnCode = ReturnCode.MESSAGE_NO_SEND_CODE;
						returnMsg = ReturnCode.MESSAGE_NO_SEND_MSG;
					}
				}else{
					returnCode = ReturnCode.TWO_INPUT_DIFF_CODE;
					returnMsg = ReturnCode.TWO_INPUT_DIFF_MSG;
				}
			}else{
				returnCode = ReturnCode.PARAMS_NULL_CODE;
				returnMsg = ReturnCode.PARAMS_NULL_MSG;
			}
		}else{
			returnCode = ReturnCode.PARAMS_MISS_CODE;
			returnMsg = ReturnCode.PARAMS_MISS_MSG;
		}
		
		returnObject.setReturnCode(returnCode);
		returnObject.setReturnMsg(returnMsg);
		return JacksonUtils.object2json(returnObject);
	}

	@Override
	public String login(Map<String,Object> map) {
		//初始化返回参数
		ReturnObject returnObject = new ReturnObject();
		String returnCode = ReturnCode.SUCCESS_CODE;
		String returnMsg = ReturnCode.SUCCESS_MSG;
		User user = new User();
		
		//1、验证参数是否完整
		if(map != null && map.get("loginName") !=null
				&& map.get("password") != null){
			//2、验证参数是否为空
			String loginName = map.get("loginName").toString();
			String password = map.get("password").toString();
			if(!StringUtils.isEmpty(loginName) && 
					!StringUtils.isEmpty(password)){
				Map<String,Object> m = new HashMap<String,Object>();
				m.put("userName", loginName);
				user = userMapper.loadAll(m);
				if(user == null){
					m.clear();
					m.put("mobile", loginName);
					user = userMapper.loadAll(m);
				}
				//3、验证用户是否存在
				if(user != null){
					//若用户被冻结，进行处理
					if(user.getStatus() == 0){
						if(user.getFreezeTime().after(new Date())){
							returnCode = ReturnCode.USER_FREEZE_CODE;
							returnMsg = "帐号被冻结，请"+ DateFormatUtils.timeDiff(new Date(), user.getFreezeTime())
									+ "分钟后登录";
							returnObject.setReturnCode(returnCode);
							returnObject.setReturnMsg(returnMsg);
							
							return JacksonUtils.object2json(returnObject);
						}else{
							//账户解冻
							Map<String,Object> o = new HashMap<String,Object>();
							o.put("status", 1);
							o.put("time", null);
							o.put("error", 5);
							o.put("userId", user.getUserId());
							userMapper.freezeUser(o);
						}
					}
					//4、验证密码是否正确
					if(!user.getPassword().equals(DigestUtils.md5Hex(password))){
						//5、密码不正确判断剩余错误次数
						if(user.getErrorLeft() == 1){
							//冻结
							Map<String,Object> o = new HashMap<String,Object>();
							o.put("status", 0);
							o.put("time", DateFormatUtils.timeAdd(new Date(), 30));
							o.put("error", 0);
							o.put("userId", user.getUserId());
							userMapper.freezeUser(o);
							
							returnCode = ReturnCode.USER_FREEZE_CODE;
							returnMsg = "帐号被冻结，请30分钟后登录";
						}else{
							//减少错误次数
							Map<String,Object> o = new HashMap<String,Object>();
							o.put("status", 1);
							o.put("time", null);
							o.put("error", (user.getErrorLeft()==0 ? 5 :user.getErrorLeft()) - 1);
							o.put("userId", user.getUserId());
							userMapper.freezeUser(o);
							
							returnCode = ReturnCode.PASSWORD_ERROR_CODE;
							returnMsg = ReturnCode.PASSWORD_ERROR_MSG;
						}
					}else{
						//登录成功,恢复5次
						Map<String,Object> o = new HashMap<String,Object>();
						o.put("status", 1);
						o.put("time", null);
						o.put("error", 5);
						o.put("userId", user.getUserId());
						userMapper.freezeUser(o);
					}
				}else{
					returnCode = ReturnCode.USER_NOT_EXSIT_CODE;
					returnMsg = ReturnCode.USER_NOT_EXSIT_MSG;
				}
			}else{
				returnCode = ReturnCode.PARAMS_NULL_CODE;
				returnMsg = ReturnCode.PARAMS_NULL_MSG;
			}
		}else{
			returnCode = ReturnCode.PARAMS_MISS_CODE;
			returnMsg = ReturnCode.PARAMS_MISS_MSG;
		}
		
		returnObject.setReturnCode(returnCode);
		returnObject.setReturnMsg(returnMsg);
		if(user != null){
			returnObject.setReturnObj(JacksonUtils.object2json(user));
		}
		return JacksonUtils.object2json(returnObject);
	}

}
