package com.spring.event.handling.demo.listeners.customeventlisteners;

import org.springframework.context.ApplicationListener;

import com.spring.event.handling.demo.events.customevents.CustomSpringEvent;

public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {

	@Override
	public void onApplicationEvent(CustomSpringEvent event) {
		System.out.println("Received Spring custom event - " + event.getMessage());		
	}

}
