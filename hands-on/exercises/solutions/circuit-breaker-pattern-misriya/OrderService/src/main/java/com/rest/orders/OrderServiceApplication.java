package com.rest.orders;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.rest.orders.entities.Order;
import com.rest.orders.repositories.OrderRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class OrderServiceApplication {

	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@PostConstruct
	public void setupData() {
		orderRepository.saveAll(Arrays.asList(
				Order.builder().id(1).itemId("123").build(),
				Order.builder().id(2).itemId("345").build()));
	}
}
