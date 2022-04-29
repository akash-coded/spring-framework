package com.spring.atm.publishers;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.spring.atm.events.WithdrawalEvent;

public class WithdrawalEventPublisher implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher applicationEventPublisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	public void sendWithdrawalNotification(final Double amount, final Double accBalance) {
		WithdrawalEvent event = new WithdrawalEvent(this, amount, accBalance);
		applicationEventPublisher.publishEvent(event);
	}

}
