package com.zqs.core.service.other.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zqs.core.dao.other.IRecommendMapper;
import com.zqs.core.service.other.IOtherService;
import com.zqs.core.utils.json.JacksonUtils;
import com.zqs.pojo.other.e.Erecmd;

public class DefultOtherServiceImpl implements IOtherService {
	
	@Autowired
	private IRecommendMapper recommendMapper;
	
	
	@Override
	public String recommend() {
		Map<String,Object> map = new HashMap<String,Object>();
		
		//轮播图
		map.put("turn", recommendMapper.load(Erecmd.TURN));
		//热门推荐
		map.put("hot", recommendMapper.load(Erecmd.HOT));
		return JacksonUtils.object2json(map);
	}

}
