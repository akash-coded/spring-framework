package com.spring.jdbc.n.tier.demo.exceptions;

public class DatabaseOperationException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4606701864818857978L;

	public DatabaseOperationException(String errorMessage) {
		super(errorMessage);
	}
	
	public DatabaseOperationException(String errorMessage, Exception e) {
		super(errorMessage, e);
	}
	
}
