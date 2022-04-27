package com.spring.event.handling.demo.listeners.standardeventlisteners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
	private static boolean applicationContextInitializedFlag = false;

	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(applicationContextInitializedFlag == false) {
			System.out.println("ApplicationContext initialized");
			applicationContextInitializedFlag = true;
		} else {

			System.out.println("ApplicationContext refreshed");
		}
	}

}
