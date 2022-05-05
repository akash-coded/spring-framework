package com.spring.boot.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "Hello Spring Boot!";
	}
	
	@GetMapping("/jsonMessage")
	public List<String> showMessage() {
		return List.of("Hello", "Spring", "Boot", "!");
	}
	
}
