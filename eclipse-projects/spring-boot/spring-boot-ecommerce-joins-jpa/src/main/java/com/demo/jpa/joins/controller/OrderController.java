package com.demo.jpa.joins.controller;

import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jpa.joins.model.Order;

@RestController
@RequestMapping("/api/orders")
@Validated
public class OrderController {

	@GetMapping("/{id}")
	public Order getOrder(@PathVariable @Min(1) Long id) {
		return null;
	}
	
}
