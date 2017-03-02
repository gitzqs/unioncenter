package com.zqs.core.service.goods.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zqs.core.dao.goods.IGoodsTypeMapper;
import com.zqs.core.service.goods.IGoodsService;
import com.zqs.core.utils.json.JacksonUtils;
import com.zqs.pojo.goods.GoodsType;

public class DefaultGoodsServiceImpl implements IGoodsService {
	
	@Autowired
	private IGoodsTypeMapper goodsTypeMapper;
	
	@Override
	public String getMenu() {
		
		//获取第一级别列表
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("level", 1);
		map.put("status", 1);
		List<GoodsType> list_1 = goodsTypeMapper.loadList(map);
		if(list_1 != null && list_1.size() >0){
			for(int i=0; i< list_1.size(); i++){
				map.clear();
				map.put("status", 1);
				map.put("parentId", list_1.get(i).getTypeId());
				List<GoodsType> list_2 = goodsTypeMapper.loadList(map);
				if(list_2 != null && list_2.size() >0){
					for(int j=0; j<list_2.size(); j++){
						map.put("parentId", list_2.get(j).getTypeId());
						list_2.get(j).setList(goodsTypeMapper.loadList(map));
					}
					list_1.get(i).setList(list_2);
				}
				
			}
		}
		return JacksonUtils.object2json(list_1);
	}

}
