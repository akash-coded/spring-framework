package com.innerbean;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {
	public CustomEvent(Object source) {
		super(source);
	}
	
	public String toString() {
		return "This is a custom event";
	}
}
