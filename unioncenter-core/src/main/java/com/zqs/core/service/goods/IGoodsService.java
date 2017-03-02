package com.zqs.core.service.goods;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/goods")
public interface IGoodsService {
	
	/**
	 * 获取首页菜单
	 * 
	 * @param 
	 * @return String
	 */
	@POST
	@Path("/menu")
	String getMenu();
}
