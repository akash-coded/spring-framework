package com.spring.jdbc.n.tier.demo.exceptions;

public class MyResourceNotDeletedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1747661336988775504L;

	public MyResourceNotDeletedException(String errorMessage) {
		super(errorMessage);
	}
	
}
