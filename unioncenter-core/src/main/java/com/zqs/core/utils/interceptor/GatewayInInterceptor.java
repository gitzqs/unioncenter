package com.zqs.core.utils.interceptor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 请求验证
 * 
 * @author qiushi.zhou  
 * @date 2017年3月2日 下午4:58:14
 */
@Service("gatewayInInterceptor")
public class GatewayInInterceptor extends AbstractPhaseInterceptor<Message> {
	
    private Logger logger = Logger.getLogger(GatewayInInterceptor.class);
    
    public GatewayInInterceptor(String phase) {
        super(phase);
    }

    public GatewayInInterceptor() {
        super(Phase.RECEIVE);
    }

    public void handleMessage(Message message) throws Fault {
        String reqParams=null;
        if(message.get(message.HTTP_REQUEST_METHOD).equals("GET")){//采用GET方式请求
            reqParams=(String) message.get(message.QUERY_STRING);
            message.remove(message.QUERY_STRING);
            reqParams=this.getParams(this.getParamsMap(reqParams));
            message.put(message.QUERY_STRING,reqParams);

        }else if(message.get(message.HTTP_REQUEST_METHOD).equals("POST")){//采用POST方式请求
            try {
                InputStream is = message.getContent(InputStream.class);
                reqParams=this.getParams(this.getParamsMap(is.toString()));
                if (is != null)
                    message.setContent(InputStream.class, new ByteArrayInputStream(reqParams.getBytes()));
            } catch (Exception e) {
                logger.error("GatewayInInterceptor Exception.",e);
            }
        } 
    }

    private Map<String,String> getParamsMap(String strParams){
        System.out.print("----------"+strParams);
        if(strParams==null||strParams.trim().length()<=0){
            return null;
        }
        Map<String,String> map =new HashMap<String,String>();
        String[] params=strParams.split("&");
        for(int i=0;i<params.length;i++){
            String[] arr=params[i].split("=");
            map.put(arr[0], arr[1]);
        }
        return map;
    }

    private String getParams(Map<String,String> map){
        if(map==null||map.size()==0){
            return null;
        }
        StringBuffer sb=new StringBuffer();
        Iterator<String> it =map.keySet().iterator();
        while(it.hasNext()){
            String key=it.next();
            String value =map.get(key);
            if(sb.length()<=0){
                sb.append(key+"="+value);
            }else{
                sb.append("&"+key+"="+value);
            }
        }
        return sb.toString();
    }

}
