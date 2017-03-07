package com.zqs.core.service.other.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zqs.core.dao.other.IRecommendMapper;
import com.zqs.core.dao.other.IValidateCodeMapper;
import com.zqs.core.service.other.IOtherService;
import com.zqs.core.utils.json.JacksonUtils;
import com.zqs.pojo.base.ReturnObject;
import com.zqs.pojo.base.e.ReturnCode;
import com.zqs.pojo.other.ValidateCode;
import com.zqs.pojo.other.e.Erecmd;

public class DefultOtherServiceImpl implements IOtherService {
	
	@Autowired
	private IRecommendMapper recommendMapper;
	@Autowired
	private IValidateCodeMapper validateCodeMapper;
	
	
	@Override
	public String recommend() {
		//返回参数
		ReturnObject returnObject = new ReturnObject();
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		//轮播图
		map.put("turn", recommendMapper.load(Erecmd.TURN));
		//热门推荐
//		map.put("hot", recommendMapper.load(Erecmd.HOT));
		
		returnObject.setReturnCode(ReturnCode.SUCCESS_CODE);
		returnObject.setReturnMsg(ReturnCode.SUCCESS_MSG);
		returnObject.setReturnData(map);
		return JacksonUtils.object2json(returnObject);
	}


	@Override
	public String getValCode(Map<String, Object> map) {
		//初始化返回参数
		ReturnObject returnObject = new ReturnObject();
		String returnCode = ReturnCode.SUCCESS_CODE;
		String returnMsg = ReturnCode.SUCCESS_MSG;
		String validateCode = null;
		
		ValidateCode code = validateCodeMapper.loadAll(map);
		if(code != null && code.getId() != null){
			if(code.getEndTime().after(new Date())){
				validateCode = code.getCode();
			}else{
				//验证码过期，更新状态
				validateCodeMapper.update(code.getId());
			}
		}
		
		returnObject.setReturnCode(returnCode);
		returnObject.setReturnMsg(returnMsg);
		returnObject.setReturnData(validateCode);
		return JacksonUtils.object2json(returnObject);
	}

}
