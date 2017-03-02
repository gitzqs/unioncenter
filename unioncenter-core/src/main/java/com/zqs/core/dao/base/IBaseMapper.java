package com.zqs.core.dao.base;

import java.util.List;
import java.util.Map;

import com.zqs.pojo.base.REntity;
import com.zqs.pojo.goods.GoodsType;

public interface IBaseMapper<T extends REntity> {
	
	/**
	 * 获取基本信息(Map)
	 * 
	 * @param 
	 * @return T
	 */
	T loadAll(Map<String,Object> map);
	
	/**
	 * 获取基本信息(long)
	 * 
	 * @param 
	 * @return T
	 */
	T load(Long id);
	
	/**
	 * 获取基本信息(String)
	 * 
	 * @param 
	 * @return T
	 */
	T load(String id);
	
	/**
	 * 获取基本信息(int)
	 * 
	 * @param 
	 * @return T
	 */
	List<T> load(int id);
	
	/**
	 * 获取基本信息(list)
	 * 
	 * @param 
	 * @return List<T>
	 */
	List<GoodsType> loadList(Map<String,Object> map);
	
	/**
	 * 新增
	 * 
	 * @param 
	 * @return int
	 */
	int save(T entity);
}
