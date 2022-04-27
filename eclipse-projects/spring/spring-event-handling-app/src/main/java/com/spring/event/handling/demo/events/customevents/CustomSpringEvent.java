package com.spring.event.handling.demo.events.customevents;

import org.springframework.context.ApplicationEvent;

public class CustomSpringEvent extends ApplicationEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4082098833437084931L;
	
	private String message;
	
	public CustomSpringEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
