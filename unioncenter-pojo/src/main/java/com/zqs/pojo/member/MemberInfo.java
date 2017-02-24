package com.zqs.pojo.member;

import java.sql.Date;

import com.zqs.pojo.base.REntity;
/**
 * 用户信息
 * 
 * @author qiushi.zhou  
 * @date 2017年2月24日 上午10:19:36
 */
public class MemberInfo extends REntity{


	private static final long serialVersionUID = 3821772347091418564L;
	
	private Long memberId;
	
	/** 用户名 */
	private String memberName;
	
	/** 用户手机 */
	private String mobileNumber;
	
	/** 邮箱 */
	private String email;
	
	/** 密码 */
	private String password;
	
	/** appid */
	private String appid;
	
	/** appkey */
	private String appkey;
	
	/** openid */
	private String openId;
	
	/** 状态 {@link EStatus.java}*/
	private int status;
	
	/** 创建时间 */
	private Date createdTime;
	
	/** 最后登录时间 */
	private Date lastLoginTime;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	
}
