package com.infinira.sms.model;

import com.infinira.sms.util.SMSUtil;

public class SMSEnum{
    public enum Gender{
        MALE("F"), FEMALE("F"), OTHERS("O");
        private final String gender;
        
        private Gender(String gender){
            this.gender = gender;
        }
        
        public static Gender validateGender(String value){
            Gender gender = null;
            for(Gender gdr:Gender.values()){
                if(gdr.gender.equalsIgnoreCase(value)){
                    gender = gdr;
                }
            }
            if(gender == null){
				SMSUtil.throwException("SMS_MSG_1033", null,value);
			}			
			return gender;
        }
    }
    
}