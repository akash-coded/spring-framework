package com.payment.microservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    public List<Payment> findByOrderId(long orderId);
}
