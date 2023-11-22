package com.rest.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.orders.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
