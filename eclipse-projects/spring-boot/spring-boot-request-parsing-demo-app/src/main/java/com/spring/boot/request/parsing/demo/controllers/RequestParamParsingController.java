package com.spring.boot.request.parsing.demo.controllers;

import java.util.Map;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requestParamParsingDemo")
public class RequestParamParsingController {

	@GetMapping("/showFullName")
	public String showFullName(@RequestParam String firstName,@RequestParam String lastName) {
		return "Full Name by concatenating the request parameters: " + firstName + " " + lastName;
	}
	
	@GetMapping("/showAllRequestParams")
	public Map<String, String> showAllRequestParams(@RequestParam Map<String, String> allRequestParams) {
		allRequestParams.put("message", "Parsing and returning all the request params as a reponse");
		return allRequestParams;
	}
	
	@GetMapping("/showAllMultiValuedRequestParams")
	public String showAllMultiValuedRequestParams(@RequestParam MultiValueMap<String, String> requestParams) {
		return requestParams.toString();
	}
	
}
