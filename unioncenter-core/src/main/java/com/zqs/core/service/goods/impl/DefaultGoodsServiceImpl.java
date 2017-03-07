package com.zqs.core.service.goods.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zqs.core.dao.goods.IGoodsMapper;
import com.zqs.core.dao.goods.IGoodsTypeMapper;
import com.zqs.core.service.goods.IGoodsService;
import com.zqs.core.utils.json.JacksonUtils;
import com.zqs.core.utils.string.StringUtils;
import com.zqs.pojo.base.ReturnObject;
import com.zqs.pojo.base.e.ReturnCode;
import com.zqs.pojo.goods.GoodsType;

public class DefaultGoodsServiceImpl implements IGoodsService {
	
	@Autowired
	private IGoodsTypeMapper goodsTypeMapper;
	@Autowired
	private IGoodsMapper goodsMapper;
	
	@Override
	public String getMenu() {
		//返回参数
		ReturnObject returnObject = new ReturnObject();
		
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
				//下属列表
				List<GoodsType> list_2 = goodsTypeMapper.loadList(map);
				if(list_2 != null && list_2.size() >0){
					for(int j=0; j<list_2.size(); j++){
						map.put("parentId", list_2.get(j).getTypeId());
						list_2.get(j).setList(goodsTypeMapper.loadList(map));
					}
					list_1.get(i).setList(list_2);
				}
				
				//所属商品
				list_1.get(i).setGoodsList(goodsMapper.loadRecGoods(list_1.get(i).getTypeId()));
				
			}
		}
		
		//返回参数
		returnObject.setReturnCode(ReturnCode.SUCCESS_CODE);
		returnObject.setReturnMsg(ReturnCode.SUCCESS_MSG);
		returnObject.setReturnData(list_1);
		return JacksonUtils.object2json(returnObject);
	}

	@Override
	public String getSingleInfo(Map<String, Object> map) {
		//返回参数
		ReturnObject returnObject = new ReturnObject();
		
		returnObject.setReturnCode(ReturnCode.SUCCESS_CODE);
		returnObject.setReturnMsg(ReturnCode.SUCCESS_MSG);
		returnObject.setReturnData(goodsMapper.loadAll(map));
		
		return JacksonUtils.object2json(returnObject);
	}

	@Override
	public String getGoodsComment(Map<String,Object> map) {
		//返回参数
		ReturnObject returnObject = new ReturnObject();
		String returnCode = ReturnCode.SUCCESS_CODE;
		String returnMsg = ReturnCode.SUCCESS_MSG;
		List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();
		
		//1、验证参数是否完整
		if(map !=null && map.get("goodsId") != null){
			String goodsId = map.get("goodsId").toString();
			//2、验证参数是否为空
			if(!StringUtils.isEmpty(goodsId)){
				results = goodsMapper.loadComment(Integer.parseInt(goodsId));
			}else{
				returnCode = ReturnCode.PARAMS_NULL_CODE;
				returnMsg = ReturnCode.PARAMS_NULL_MSG;
			}
		}else{
			returnCode = ReturnCode.PARAMS_MISS_CODE;
			returnMsg = ReturnCode.PARAMS_MISS_MSG;
		}
		returnObject.setReturnCode(returnCode);
		returnObject.setReturnMsg(returnMsg);
		returnObject.setReturnData(results);
		
		return JacksonUtils.object2json(returnObject);
	}

}
