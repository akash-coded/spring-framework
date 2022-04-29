package com.spring.atm;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.atm.publishers.WithdrawalEventPublisher;

public class AtmApplication {
	
	public static void main(String...args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		WithdrawalEventPublisher publisher = context.getBean("withdrawalEventPublisher", WithdrawalEventPublisher.class);
		publisher.sendWithdrawalNotification(5000.0, 15000.0);
		
		context.close();
	}
	
}
