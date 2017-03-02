package com.zqs.pojo.other;

import com.zqs.pojo.base.REntity;
/**
 * 请求验证
 * 
 * @author qiushi.zhou  
 * @date 2017年3月2日 下午4:42:09
 */
public class Appkey extends REntity{

	private static final long serialVersionUID = 583111886694105382L;
	
	private Long id;
	
	private String appid;
	
	private String appkey;
	
	/** 状态 */
	private int status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
