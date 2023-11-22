package com.rest.inventory.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.inventory.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByType(String type);
}
