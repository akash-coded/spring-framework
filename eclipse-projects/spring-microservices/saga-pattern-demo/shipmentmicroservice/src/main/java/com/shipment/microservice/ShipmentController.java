package com.shipment.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ShipmentController {

    @Autowired
    private ShipmentRepository repository;

    @Autowired
    private KafkaTemplate<String, InventoryEvent> kafkaTemplate;

    @KafkaListener(topics = "new-inventory", groupId = "inventory-group")
    public void shipOrder(String event) throws JsonMappingException, JsonProcessingException {

        Shipment shipment = new Shipment();
        InventoryEvent inventoryEvent = new ObjectMapper().readValue(event, InventoryEvent.class);
        CustomerOrder order = inventoryEvent.getOrder();
        try {

            if (order.getAddress() == null) {
                throw new Exception("Address not present");
            }

            shipment.setAddress(order.getAddress());
            shipment.setOrderId(order.getOrderId());

            shipment.setStatus("success");

            this.repository.save(shipment);

            // do other shipment logic ..

        } catch (Exception e) {
            shipment.setOrderId(order.getOrderId());
            shipment.setStatus("failed");
            this.repository.save(shipment);

            InventoryEvent reverseEvent = new InventoryEvent();

            reverseEvent.setType("INVENTORY_REVERSED");
            System.out.println(order);
            reverseEvent.setOrder(order);
            this.kafkaTemplate.send("reversed-inventory", reverseEvent);

        }
    }

}
