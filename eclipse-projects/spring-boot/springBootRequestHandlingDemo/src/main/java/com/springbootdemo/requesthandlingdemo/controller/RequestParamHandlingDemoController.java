package com.springbootdemo.requesthandlingdemo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamHandlingDemoController {
	
	@GetMapping("/showName")
	public String showName(@RequestParam String firstName, @RequestParam String lastName) {
		return String.format("Firstname: %s</br>Lastname: %s", firstName, lastName);
	}
	
	@GetMapping("/showNamePartly")
	public String showNamePartly(@RequestParam String firstName, @RequestParam(required=false) String lastName) {
		return String.format("Firstname: %s</br>Lastname: %s", firstName, lastName);
	}
	
	@GetMapping("/showNameOptionally")
	public String showNameOptionally(@RequestParam String firstName, @RequestParam Optional<String> lastName) {
		return String.format("Firstname: %s</br>Lastname: %s", firstName, lastName);
	}
	
	@GetMapping("/showNameWithDefaults")
	public String showNameWithDefaults(@RequestParam(defaultValue="NA") String firstName, @RequestParam Optional<String> lastName) {
		return String.format("Firstname: %s</br>Lastname: %s", firstName, lastName.orElseGet(() -> "not provided"));
	}
	
	@GetMapping("/showAllParams")
	public String showAllParams(@RequestParam Map<String, String> allParams) {
		return "Parameters:: " + allParams.entrySet();
	}
	
	// To read data sent by POST method from a form
	@PostMapping(path = "/showAuthCredentials", 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String showAuthCredentials(@RequestParam MultiValueMap<String, String> paramMap) {
		return String.format("Email: %s</br>Password: %s", paramMap.get("email"), paramMap.get("password"));
	}
}
