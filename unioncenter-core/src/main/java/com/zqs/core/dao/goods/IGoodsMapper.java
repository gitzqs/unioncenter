package com.zqs.core.dao.goods;

import java.util.List;
import java.util.Map;

import com.zqs.core.dao.base.IBaseMapper;
import com.zqs.pojo.goods.Goods;

public interface IGoodsMapper extends IBaseMapper<Goods>{
	
	/**
	 * 商品评论
	 * 
	 * @param 
	 * @return List<Map<String,Object>>
	 */
	List<Map<String,Object>> loadComment(int goodsId);
	
	/**
	 * 首页商品展示
	 * 
	 * @param 
	 * @return List<Map<String,Object>>
	 */
	List<Goods> loadRecGoods(Long typeId);
	
	/**
	 * 获取购物车
	 * 
	 * @param 
	 * @return List<Map<String,Object>>
	 */
	List<Map<String,Object>> loadGoodsCart(long userId);
}
