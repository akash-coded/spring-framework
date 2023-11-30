package com.example.stock.management;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventService {

	@Autowired
	private EventRepository repo;

	public void addEvent(StockAddedEvent event) throws JsonProcessingException {

		EventStore eventStore = new EventStore();

		eventStore.setEventData(new ObjectMapper().writeValueAsString(event.getStockDetails()));

		eventStore.setEventType("STOCK_ADDED");

		eventStore.setEntityId(event.getStockDetails().getName());

		eventStore.setEventTime(LocalDateTime.now());

		repo.save(eventStore);
	}

	public void addEvent(StockRemovedEvent event) throws JsonProcessingException {

		EventStore eventStore = new EventStore();

		eventStore.setEventData(new ObjectMapper().writeValueAsString(event.getStockDetails()));

		eventStore.setEventType("STOCK_REMOVED");
		eventStore.setEntityId(event.getStockDetails().getName());

		eventStore.setEventTime(LocalDateTime.now());

		repo.save(eventStore);
	}

	public Iterable<EventStore> fetchAllEvents(String name) {

		return repo.findByEntityId(name);

	}
	
	public Iterable<EventStore> fetchAllEventsTillDate(String name,LocalDateTime date) {

		return repo.findByEntityIdAndEventTimeLessThanEqual(name, date);

	}
}
