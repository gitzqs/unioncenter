package com.zqs.core.service.user.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zqs.core.dao.user.IUserMapper;
import com.zqs.core.service.user.IUserService;
import com.zqs.core.utils.json.JacksonUtils;
import com.zqs.pojo.base.ReturnObject;
import com.zqs.pojo.base.e.ReturnCode;
import com.zqs.pojo.user.User;

public class DefaultUserServiceImpl implements IUserService {
	
	private Logger logger = LoggerFactory.getLogger(DefaultUserServiceImpl.class);
	
	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public String loadAll(Map<String, Object> map) {
		User user = userMapper.loadAll(map);
		
		return JacksonUtils.object2json(user);
	}

	@Override
	public String save(User user) {
		//返回参数
		ReturnObject returnObject = new ReturnObject();
		String returnCode = ReturnCode.SUCCESS_CODE;
		String returnMsg = ReturnCode.SUCCESS_MSG;
		
		try{
			userMapper.save(user);
		}catch(Exception e){
			logger.error("注册新用户发生错误,[{}]",e);
			returnCode = ReturnCode.PROGRAM_ERROR_CODE;
			returnMsg = ReturnCode.PROGRAM_ERROR_MSG;
		}
		
		returnObject.setReturnCode(returnCode);
		returnObject.setReturnMsg(returnMsg);
		
		return JacksonUtils.object2json(returnObject);
	}

}
