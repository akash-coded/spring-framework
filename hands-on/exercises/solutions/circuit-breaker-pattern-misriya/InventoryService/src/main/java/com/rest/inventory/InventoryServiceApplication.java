package com.rest.inventory;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.inventory.entities.Item;
import com.rest.inventory.repositories.ItemRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class InventoryServiceApplication {

	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@PostConstruct
	public void setupData() {
		itemRepository.saveAll(Arrays.asList(
			Item.builder().id(1).type("CLOTHING").name("FROCK").build(),
			Item.builder().id(2).type("FURNITURE").name("STUDY TABLE").build()
		));
	}
}
