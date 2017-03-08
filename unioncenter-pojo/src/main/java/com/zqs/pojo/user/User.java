package com.zqs.pojo.user;


import java.util.Date;

import com.zqs.pojo.base.REntity;
import com.zqs.pojo.base.e.EStatus;
/**
 * 用户基本信息
 * 
 * @author qiushi.zhou  
 * @date 2017年2月28日 下午4:21:17
 */
public class User extends REntity{

	private static final long serialVersionUID = 2632778902179628847L;
	
	private Long userId;
	
	/** 用户名 */
	private String userName;
	
	/** 手机号 */
	private String mobile;
	
	/** 密码 */
	private String password;
	
	/** 再次密码 */
	private String passwordAgain;
	
	/** 短信验证码 */
	private String messageCode;
	
	/** 图片验证码 */
	private String imgCode;
	
	/** 剩余错误次数 */
	private int errorLeft;
	
	/** 冻结到期时间 */
	private Date freezeTime;
	
	/** appid */
	private String appid;
	
	/** appkey */
	private String appkey;
	
	/** 微信id */
	private String openId;
	
	/** 最近登录时间 */
	private Date lastLoginTime;
	
	/** 注册时间 */
	private Date regTime;
	
	/** 状态  {@link EStatus.java}*/
	private int status;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}

	public int getErrorLeft() {
		return errorLeft;
	}

	public void setErrorLeft(int errorLeft) {
		this.errorLeft = errorLeft;
	}

	public Date getFreezeTime() {
		return freezeTime;
	}

	public void setFreezeTime(Date freezeTime) {
		this.freezeTime = freezeTime;
	}
	
	
}
