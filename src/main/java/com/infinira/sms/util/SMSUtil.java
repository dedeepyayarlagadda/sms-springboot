package com.infinira.sms.util;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSUtil{
	
	private static final Logger logger = LoggerFactory.getLogger(SMSUtil.class.getName());
    public static void validateString(String value, String mes){
        if(value == null || value.isEmpty()){
            throw new RuntimeException(mes);
        }        
    }
    
    public static SMSException throwException(String msgID, Throwable th, Object... params) {
    
    	String msg = ResourceUtil.getInstance().getSMSMessage(msgID);
    	String formattedMsg;
		try {
			formattedMsg = MessageFormat.format(msg, params);
		}catch(Throwable e) {
			logger.debug(msg, params);
			//throw new RuntimeException("Failed to format the message" + msg + "with params", th);
			formattedMsg = msgID + "with params";
		}	
    	
    	return new SMSException(formattedMsg, th);
    }
}