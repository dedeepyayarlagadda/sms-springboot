package com.infinira.sms.util;

public class SMSException extends RuntimeException{
	public SMSException(String msg,Throwable th) {
		super(msg,th);
	}
}
