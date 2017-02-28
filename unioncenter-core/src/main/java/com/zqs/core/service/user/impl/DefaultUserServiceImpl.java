package com.zqs.core.service.user.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zqs.core.dao.user.IUserMapper;
import com.zqs.core.service.user.IUserService;
import com.zqs.core.utils.json.JacksonUtils;
import com.zqs.pojo.user.User;

public class DefaultUserServiceImpl implements IUserService {
	
	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public String loadAll(Map<String, Object> map) {
		User user = userMapper.loadAll(map);
		
		return JacksonUtils.object2json(user);
	}

}
