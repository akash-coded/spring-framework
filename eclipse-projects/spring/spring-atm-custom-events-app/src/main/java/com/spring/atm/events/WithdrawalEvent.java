package com.spring.atm.events;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationEvent;

public class WithdrawalEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9209473482448961822L;

	private Double amount;
	private Double accBalance;

	public WithdrawalEvent(Object source, Double amount, Double accBalance) {
		super(source);
		this.amount = amount;
		this.accBalance = accBalance;
	}

	public String getMessage() {
		return String.format(
				"""
					Rs. %.2f was withdrawn from your bank account on %s. 
					The remaining account balance is %.2f. 
					If this transaction was not done by you, please contact support.""", 
						amount,
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.getTimestamp())),
						accBalance);
	}

}
