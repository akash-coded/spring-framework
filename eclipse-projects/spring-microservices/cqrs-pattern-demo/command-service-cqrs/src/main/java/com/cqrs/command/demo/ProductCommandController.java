package com.cqrs.command.demo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
    private final ProductRepository repository;
    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;
    

    public ProductCommandController(ProductRepository repository, KafkaTemplate<String, ProductEvent> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
        
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
       product =  repository.save(product);
        ProductEvent event = new ProductEvent("ProductCreated", product);

        
        this.kafkaTemplate.send("products", event);
        return ResponseEntity.ok().body(product);
    }
}

