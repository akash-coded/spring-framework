package com.spring.boot.foobar.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "Hello visitor!\nVisiting time: "
				+ DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
	}
	
	@GetMapping("/home")
	public String home() {
		return "You are visiting the home page using GET method...";
	}
	
	@PostMapping("/home")
	public String homePost() {
		return "You are visiting the home page using POST method...";
	}
	
	@GetMapping("/home-json")
	public Map<String, String> homeJson() {
		Map<String, String> responseMap = new HashMap<>();
		responseMap.put("language", "Java");
		responseMap.put("framework", "Spring Boot");
		responseMap.put("IDE", "Eclipse");
		
		return responseMap;
	}

}
