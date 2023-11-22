package com.rest.orders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.orders.dtos.Item;
import com.rest.orders.entities.Order;
import com.rest.orders.repositories.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String GET_SERVICE_NAME = "order-service-get";
    private static final String POST_SERVICE_NAME = "order-service-post";

    private static final String INVENTORY_SERVICE_URL = "http://localhost:8081/api/item/";

    @CircuitBreaker(name = GET_SERVICE_NAME, fallbackMethod = "getDefaultOrders")
    public Order getOrderById(Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Item> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Item> response = restTemplate.exchange(
                (INVENTORY_SERVICE_URL + id),
                HttpMethod.GET, entity,
                Item.class);
        Item item = response.getBody();
        Order order = null;
        if (item != null) {
        	System.out.println("Item exists!");
        	order = orderRepository.findById(id).orElse(null);
        }
        return order;
    }

    public Order getDefaultOrders(Exception e) throws Exception {
        throw new Exception("No item found for the provided order");
    }
    
    @CircuitBreaker(name = POST_SERVICE_NAME, fallbackMethod = "getDefaultOrders")
    public Order save(Order order) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Item> entity = new HttpEntity<>(null, headers);
        ResponseEntity<Item> response = restTemplate.exchange(
                (INVENTORY_SERVICE_URL + order.getItemId()),
                HttpMethod.GET, entity,
                Item.class);
        Item item = response.getBody();
        if (item != null) {
        	System.out.println("Item exists during save!");
        	return orderRepository.save(order);
        }
        return null;
    }

}
