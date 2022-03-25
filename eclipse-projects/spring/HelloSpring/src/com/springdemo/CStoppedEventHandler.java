package com.springdemo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

public class CStoppedEventHandler implements ApplicationListener<ContextStoppedEvent> {
	public void onApplicationEvent(ContextStoppedEvent event) {
		System.out.println("ContextStoppedEvent handled");
	}
}
