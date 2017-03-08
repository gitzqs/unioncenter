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
	
	/** 两次输入密码不一致 */
	String TWO_INPUT_DIFF_CODE = "1002";
	
	String TWO_INPUT_DIFF_MSG = "两次输入密码不一致";
	
	/** 短信验证码错误 */
	String VALIDATE_ERROR_CODE = "1003";
	
	String VALIDATE_ERROR_MSG = "短信验证码错误";
	
	/** 手机号已注册 */
	String MOBILE_EXSIT_CODE = "1004";
	
	String MOBILE_EXSIT_MSG = "手机号已注册";
	
	/** 用户名已存在 */
	String NAME_EXSIT_CODE = "1005";
	
	String NAME_EXSIT_MSG = "用户名已存在";
	
	/** 短信验证码未发送或已过期 */
	String MESSAGE_NO_SEND_CODE = "1006";
	
	String MESSAGE_NO_SEND_MSG = "短信验证码未发送或已过期";
	
	/** 用户不存在 */
	String USER_NOT_EXSIT_CODE = "1007";
	
	String USER_NOT_EXSIT_MSG = "用户不存在";
	
	/** 用户被冻结 */
	String USER_FREEZE_CODE = "1008";
	
	String USER_FREEZE_MSG = "账户被冻结";
	
	/** 密码错误 */
	String PASSWORD_ERROR_CODE = "1009";
	
	String PASSWORD_ERROR_MSG = "密码错误";
	
	/** 程序错误 */
	String PROGRAM_ERROR_CODE = "9999";
	
	String PROGRAM_ERROR_MSG = "程序发生错误";
}
