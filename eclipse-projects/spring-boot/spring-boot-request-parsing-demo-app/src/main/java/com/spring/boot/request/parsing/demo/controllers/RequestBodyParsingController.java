package com.spring.boot.request.parsing.demo.controllers;

import java.util.Map;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.request.parsing.demo.models.User;

@RestController
@RequestMapping("/requestBodyParsingDemo")
public class RequestBodyParsingController {
	
	@PostMapping("/displayRequestBody")
	public Map<String, String> addAndShowRequestBody(@RequestBody Map<String, String> requestBody) { // Deserializing the RequestBody to a Map
		requestBody.put("message", "Displaying the request payload with a response message");
		return requestBody;
	}
	
//	MultiValueMap<String, String> = Map<String, List<String>>
	@PostMapping("/displayFormRequestBody")
	public Map<String, String> parseAndShowMultiValuedRequestBody(@RequestBody MultiValueMap<String, String> formInputs) {
		Map<String, String> responseBody = formInputs.toSingleValueMap();
		responseBody.put("message", "Displaying the form inputs with a response message");
		return responseBody;
	}
	
	@PostMapping("/displayUserFromJson")
	public User displayUserFromJson(@RequestBody User user) { // Deserializing the RequestBody to a User instance
		return user;
	}
	
}
