package com.springbootdemo.requesthandlingdemo.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.requesthandlingdemo.model.User;

@RestController
public class RequestBodyHandlingDemoController {
	@PostMapping(path = "/showCredentials")
	public User showCredentials(@RequestBody User user) {
		return user;
	}
	
	@PostMapping("/showRequestBody")
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, String> showRequestBody(@RequestBody Map<String, String> requestBody) { // Deserializing RequestBody to Map
		return requestBody;
	}
}
