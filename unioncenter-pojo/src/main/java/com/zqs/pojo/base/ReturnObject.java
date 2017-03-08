package com.zqs.pojo.base;


/**
 * 返回参数
 * 
 * @author qiushi.zhou  
 * @date 2017年3月3日 下午2:13:14
 */
public class ReturnObject extends REntity{

	private static final long serialVersionUID = 4306428149004443000L;
	
	/** 返回代码 */
	private String returnCode;
	
	/** 返回信息 */
	private String returnMsg;
	
	/** 返回数据 */	
	private Object returnData;
	
	/** 返回实体类 */
	private String returnObj;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public Object getReturnData() {
		return returnData;
	}

	public void setReturnData(Object returnData) {
		this.returnData = returnData;
	}

	public String getReturnObj() {
		return returnObj;
	}

	public void setReturnObj(String returnObj) {
		this.returnObj = returnObj;
	}
	
	

}
