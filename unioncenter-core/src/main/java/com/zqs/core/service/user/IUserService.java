package com.zqs.core.service.user;

import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.zqs.pojo.user.User;

@Path("/user")
public interface IUserService {
	
	/**
	 * 获取用户基本信息
	 * 
	 * @param 
	 * @return String
	 */
	@POST
	@Path("/loadAll")
	String loadAll(Map<String,Object> map);
	
	/** 
	 * 注册
	 * 
	 * @param 
	 * @return String
	 */
	@POST
	@Path("/save")
	String save(User user);
}
