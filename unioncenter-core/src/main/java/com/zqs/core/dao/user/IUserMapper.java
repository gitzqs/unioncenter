package com.zqs.core.dao.user;

import java.util.Map;

import com.zqs.core.dao.base.IBaseMapper;
import com.zqs.pojo.user.User;

public interface IUserMapper extends IBaseMapper<User>{
	
	/**
	 * 验证用户是否存在
	 * 
	 * @param 
	 * @return int
	 */
	int isUserExist(User user);
	
	/**
	 * 冻结或者解冻账户
	 * 
	 * @param 
	 * @return void
	 */
	void freezeUser(Map<String,Object> map);
}
