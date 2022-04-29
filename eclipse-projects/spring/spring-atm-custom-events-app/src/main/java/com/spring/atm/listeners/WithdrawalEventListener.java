package com.spring.atm.listeners;

import org.springframework.context.ApplicationListener;

import com.spring.atm.events.WithdrawalEvent;

public class WithdrawalEventListener implements ApplicationListener<WithdrawalEvent> {

	public void onApplicationEvent(WithdrawalEvent event) {
		System.out.println("Sending withdrwal notification SMS...");
		
		System.out.println("SMS Body: " + event.getMessage());
		
		// code to send SMS
		
		System.out.println("SMS Sent.");
	}

}
