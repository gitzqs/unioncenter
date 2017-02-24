package com.zqs.core.service.member;

import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/memberInfo")
public interface IMemberService {
	
	/**
	 * 获取用户基本信息
	 * 
	 * @param 
	 * @return String
	 */
	@POST
	@Path("/loadAll")
	String load(Map<String,Object> map);
}
