package com.spring.boot.testing.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.testing.demo.services.GreetingService;

@Controller
public class GreetingController {

	private final GreetingService service;
	
	public GreetingController(GreetingService service) {
		this.service = service;
	}
	
	@RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		return service.greet();
	}
}
