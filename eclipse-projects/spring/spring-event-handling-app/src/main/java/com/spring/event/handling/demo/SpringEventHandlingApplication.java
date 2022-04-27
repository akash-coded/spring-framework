package com.spring.event.handling.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.event.handling.demo.publishers.customeventpublishers.CustomSpringEventPublisher;

public class SpringEventHandlingApplication {

	public static void main(String[] args) {
		System.out.println("Demonstrating event handling in Spring: -");
		System.out.println("\nExisting framework events::");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		context.refresh();
		context.stop();
		context.start();
		
		System.out.println("\nCustom events::");
		CustomSpringEventPublisher publisher = context.getBean("customSpringEventPublisher", CustomSpringEventPublisher.class);
		publisher.publishCustomEvent("CustomEvent published");
		
		context.close();
	}

}
