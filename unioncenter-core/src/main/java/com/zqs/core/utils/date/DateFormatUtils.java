
package com.zqs.core.utils.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.util.StringUtils;

/**
 * 时间相关操作
 * 
 * @author qiushi.zhou  
 * @date 2017年2月24日 上午09:10:44
 */
public class DateFormatUtils {
    private static final Logger logger = LoggerFactory.getLogger(DateFormatUtils.class);
    
    public static final String ymd = "yyyy-MM-dd";
    public static final String ymd_hms = "yyyy-MM-dd HH:mm:ss";
    
    private static ThreadLocal<Map<String, DateFormat>> dateFormat = new ThreadLocal<Map<String, DateFormat>>();
    
    
    public static DateFormat getDateFormat(String pattern) {
        Map<String, DateFormat> dfMap = dateFormat.get();
        if (dfMap == null) {
            dfMap = new HashMap<String, DateFormat>();
            dateFormat.set(dfMap);
        }
        if (StringUtils.isEmpty(pattern)) throw new IllegalArgumentException("date format patter must not be null or empty!");

        DateFormat df = dfMap.get(pattern);
        if (df == null) {
            df = new SimpleDateFormat(pattern);
            dfMap.put(pattern, df);
        }
        return dfMap.get(pattern);
    }
    
    public static String format(Date date, String pattern) {
        DateFormat df = getDateFormat(pattern);
        return df.format(date);
    }
    
    public static Date parse(String source, String pattern) {
        DateFormat df = getDateFormat(pattern);
        try {
            return df.parse(source);
        } catch (ParseException e) {
            logger.error("can't parse source: [{}] to date! catched ParseException:\n\t{}", new Object[]{source, e.getLocalizedMessage()});
        } catch (Exception e) {
            logger.error("can't parse source: [{}] to date! catched Exception:\n\t{}", new Object[]{source, e.getLocalizedMessage()});
        }
        return null;
    }
    
    /**
     * 两个时间相差分钟数
     * 
     * @param date1 较小的时间
     * @param date2 较大的时间
     * @return String
     */
    public static long timeDiff(Date date1,Date date2){
    	
    	return (date2.getTime() - date1.getTime())/(1000 * 60);
    }
    
    /**
     * 某时间上加上index分钟
     * 
     * @param date 处理前时间
     * @param index 分钟数
     * @return Date
     */
    public static Date timeAdd(Date date, int index){
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.MINUTE, index);
    	
    	return cal.getTime();
    }
    
    public static void main(String args[]){
    	
    	System.out.println(timeAdd(new Date(),30));
    }
    
}
