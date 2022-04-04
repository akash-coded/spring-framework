package com.springbootdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // returns data rather than view
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "Hello Spring Boot!";
	}
	
	@GetMapping("/jsonMessage")
	public List<String> welcomeMessage() {
		return List.of("Hello", "Spring", "Boot", "!");
	}
}
