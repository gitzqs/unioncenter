package com.zqs.core.utils.string;
/**
 * 字符串处理
 * 
 * @author qiushi.zhou  
 * @date 2017年3月6日 下午3:55:08
 */
public class StringUtils {
	
	/**
	 * 判断是否为空
	 * 
	 * @param 
	 * @return boolean
	 */
	public static boolean isEmpty(String temp){
		
		return temp.trim().equals("") || temp.equals(null);
	}
}
