package com.zqs.core.dao.base;

import java.util.Map;

import com.zqs.pojo.base.REntity;

public interface IBaseMapper<T extends REntity> {
	
	/**
	 * 获取用户基本信息(Map)
	 * 
	 * @param 
	 * @return T
	 */
	T loadAll(Map<String,Object> map);
	
	/**
	 * 获取用户基本信息(long)
	 * 
	 * @param 
	 * @return T
	 */
	T load(Long id);
	
	/**
	 * 新增
	 * 
	 * @param 
	 * @return int
	 */
	int save(T entity);
}
