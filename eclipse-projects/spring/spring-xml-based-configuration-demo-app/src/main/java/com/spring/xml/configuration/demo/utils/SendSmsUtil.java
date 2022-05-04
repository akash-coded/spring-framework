package com.spring.xml.configuration.demo.utils;

public class SendSmsUtil {
	
	public void sendSms(String message) {
		System.out.println("Sending SMS...");
		System.out.println("SMS Body:: " + message);
		System.out.println("SMS Sent...");
	}
	
}
