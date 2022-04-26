package com.spring.boot.swagger.demo.resources;

import com.spring.boot.swagger.demo.models.Contact;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contacts")
public class AddressBookResource {
	
	ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();

	@GetMapping("/{id}")
	@ApiOperation(value = "Finds Contacts by id",
			notes = "Provide an id to look up specific contact from the address book",
			response = Contact.class)
	public Contact getContact(@ApiParam(value = "ID value for the contact you need to retrieve", required = true) @PathVariable String id) {
		return contacts.get(id);
	}
	
	@GetMapping("/all")
	public List<Contact> getAllContacts() {
		return contacts.values().stream().toList();
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String addContact(@RequestBody Contact contact) {
		contacts.put(contact.getId(), contact);
		return "Contact added successfully";
	}
	
}
