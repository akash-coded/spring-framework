package com.example.stock.management;

import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data

public class EventStore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eventId;

	private String eventType;

	private String entityId;
	
	private String eventData;

	private LocalDateTime eventTime;

}
