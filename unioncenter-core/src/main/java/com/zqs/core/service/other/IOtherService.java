package com.zqs.core.service.other;

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
}
