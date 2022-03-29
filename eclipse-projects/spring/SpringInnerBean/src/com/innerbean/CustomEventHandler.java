package com.innerbean;

import org.springframework.context.ApplicationListener;

public class CustomEventHandler implements ApplicationListener<CustomEvent> {
	public void onApplicationEvent(CustomEvent event) {
		System.out.println("Custom Event Raised:: " + event.toString());
	}
}
//A2108038135-0006