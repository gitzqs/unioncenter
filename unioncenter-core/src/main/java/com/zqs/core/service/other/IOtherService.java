package com.zqs.core.service.other;

import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/other")
public interface IOtherService {
	
	/**
	 * 获取推荐信息
	 * 
	 * @param 
	 * @return String
	 */
	@POST
	@Path("/recommend")
	String recommend();
	
	/**
	 * 获取验证码
	 * 
	 * @param 
	 * @return String
	 */
	@POST
	@Path("/validateCode")
	String getValCode(Map<String,Object> map);
}
