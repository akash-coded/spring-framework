package com.example.stock.management;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface EventRepository extends CrudRepository<EventStore, Long>{


	Iterable<EventStore> findByEntityId(String entityId);
	
	Iterable<EventStore> findByEntityIdAndEventTimeLessThanEqual(String entityId,LocalDateTime date);
}

