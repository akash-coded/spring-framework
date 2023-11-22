package com.rest.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.inventory.entities.Item;
import com.rest.inventory.services.InventoryService;

@RestController
@RequestMapping("api")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping(path = "/item/{id}")
    public ResponseEntity<Item> getInventoryById(@PathVariable("id") String id) {
        System.out.println("In Inventory controller with id:"+ id);
    	return ResponseEntity.ok().body(inventoryService.getItemById(id));
    }
}
