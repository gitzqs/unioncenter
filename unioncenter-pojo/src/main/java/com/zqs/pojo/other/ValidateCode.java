package com.zqs.pojo.other;

import java.util.Date;

import com.zqs.pojo.base.REntity;

public class ValidateCode extends REntity{

	private static final long serialVersionUID = 6620417200292549352L;
	
	private Long id;
	
	/** 手机号 */
	private String mobile;
	
	/** 类别 */
	private int type;
	
	/** 验证码 */
	private String code;
	
	/** 开始时间 */
	private Date beginTime;
	
	/** 过期时间 */
	private Date endTime;
	
	/** 状态 */
	private int status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
