package com.zqs.pojo.base.e;
/**
 * 返回编码
 * 
 * @author qiushi.zhou  
 * @date 2017年3月3日 下午2:20:57
 */
public interface ReturnCode {
	
	/** 操作成功 */
	String SUCCESS_CODE = "0000"; 
	
	String SUCCESS_MSG = "操作成功";
	
	/** 参数不完整 */
	String PARAMS_MISS_CODE = "1000";
	
	String PARAMS_MISS_MSG = "参数不完整";
	
	/** 参数为空 */
	String PARAMS_NULL_CODE = "1001";
	
	String PARAMS_NULL_MSG = "参数为空";
}
