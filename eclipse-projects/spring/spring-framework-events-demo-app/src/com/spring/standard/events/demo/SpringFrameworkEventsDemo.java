package com.spring.standard.events.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringFrameworkEventsDemo {
	
	public static void main(String...args) {
		System.out.println("Demonstrating Standard Spring Framework Events::");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context-config.xml");
		context.refresh();
		context.stop();	
		context.start();		
		context.close(); // publishes ContextClosedEvent instance
	}
	
}
