package com.spring.event.handling.demo.publishers.customeventpublishers;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.spring.event.handling.demo.events.customevents.CustomSpringEvent;

public class CustomSpringEventPublisher implements ApplicationEventPublisherAware {
	
	private ApplicationEventPublisher applicationEventPublisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	public void publishCustomEvent(final String message) {
		System.out.println("Publishing custom event.");
		CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
		applicationEventPublisher.publishEvent(customSpringEvent);
	}
	
}
