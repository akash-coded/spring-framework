package com.rest.orders.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.orders.entities.Order;
import com.rest.orders.services.OrderService;

@RestController
@RequestMapping("api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/orders/{id}")
    public ResponseEntity<Order> getOrdersByType(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }
    

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    	return ResponseEntity.ok().body(orderService.save(order));
    }
}
