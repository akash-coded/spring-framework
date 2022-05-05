package com.spring.standard.events.demo.eventlisteners.standardeventlisteners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent>{
	private static boolean applicationContextInitialized = false;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		if(applicationContextInitialized == false) {
			System.out.println("ApplicationContext initialized.");
			applicationContextInitialized = true;
		} else {	
			System.out.println("ApplicationContext refreshed.");	
		}
	}

}
