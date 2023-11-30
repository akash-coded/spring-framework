package com.cqrs.query.demo;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/products")
public class ProductQueryController {
	private final ProductRepository repository;

	public ProductQueryController(ProductRepository repository) {
		this.repository = repository;
	}

	@KafkaListener(topics = "products", groupId = "products_group")
	public void processProductEvent(String event) {

		System.out.println("Getting event " + event);

		ProductEvent productEvent = null;
		try {
			productEvent = new ObjectMapper().readValue(event, ProductEvent.class);

			System.out.println(productEvent);

			switch (productEvent.getType()) {
			case "ProductCreated":
				
				this.repository.save(productEvent.getProduct());
				break;

			default:
				break;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@GetMapping
	public List<Product> getProducts() {
		return repository.findAll().stream()

				.collect(Collectors.toList());
	}
}
