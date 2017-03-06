package com.zqs.core.service.goods;

import java.util.Map;

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
	
	/**
	 * 获取单个商品的信息
	 * 
	 * @param 
	 * @return String
	 */
	@POST
	@Path("/singleInfo")
	String getSingleInfo(Map<String,Object> map);
	
	/**
	 * 获取商品评论
	 * 
	 * @param 
	 * @return String
	 */
	@POST
	@Path("/comment")
	String getGoodsComment(Map<String,Object> map);
}
