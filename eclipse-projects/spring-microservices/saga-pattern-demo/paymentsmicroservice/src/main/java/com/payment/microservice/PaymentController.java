package com.payment.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaOrderTemplate;

    @KafkaListener(topics = "new-orders", groupId = "orders-group")
    public void processPayment(String event) throws JsonMappingException, JsonProcessingException {

        System.out.println("Recieved event" + event);
        OrderEvent orderEvent = new ObjectMapper().readValue(event, OrderEvent.class);

        CustomerOrder order = orderEvent.getOrder();
        Payment payment = new Payment();
        try {

            // save payment details in db
            payment.setAmount(order.getAmount());
            payment.setMode(order.getPaymentMode());
            payment.setOrderId(order.getOrderId());
            payment.setStatus("SUCCESS");
            this.repository.save(payment);

            // publish payment created event for inventory microservice to consume.

            PaymentEvent paymentEvent = new PaymentEvent();
            paymentEvent.setOrder(orderEvent.getOrder());
            paymentEvent.setType("PAYMENT_CREATED");
            this.kafkaTemplate.send("new-payments", paymentEvent);
        } catch (Exception e) {

            payment.setOrderId(order.getOrderId());
            payment.setStatus("FAILED");
            repository.save(payment);

            // reverse previous task
            OrderEvent oe = new OrderEvent();
            oe.setOrder(order);
            oe.setType("ORDER_REVERSED");
            this.kafkaOrderTemplate.send("reversed-orders", orderEvent);

        }

    }

}
