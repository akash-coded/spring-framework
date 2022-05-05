package com.spring.boot.request.parsing.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

	@GetMapping("")
	public String welcomeVisitor() {
		System.out.println("HomeController::welcomeVisitor() executed");
		
		return "Hello visitor! Welcome to Spring Boot request parsing.";
	}
	
	@GetMapping("/json")
	public List<String> welcomeVisitorWithJson() {
		System.out.println("HomeController::welcomeVisitorWithJson() executed");
		
		return List.of("Hello", "visitor", "!", "Welcome", "to", "Spring", "Boot", ".");
	}
	
}
