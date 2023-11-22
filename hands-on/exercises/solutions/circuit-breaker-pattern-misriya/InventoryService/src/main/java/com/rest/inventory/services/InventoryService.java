package com.rest.inventory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.inventory.entities.Item;
import com.rest.inventory.repositories.ItemRepository;

@Service
public class InventoryService {

    @Autowired
    private ItemRepository repository;

    public Item getItemById(String id) {
        return repository.findById(Integer.parseInt(id)).orElseThrow(() -> new RuntimeException("Item Not Found: " + id));
    }
}
