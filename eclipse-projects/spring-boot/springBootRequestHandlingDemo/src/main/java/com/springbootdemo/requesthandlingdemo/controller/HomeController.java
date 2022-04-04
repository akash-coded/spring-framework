package com.springbootdemo.requesthandlingdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
		
		return "Welcome to request handling with Spring Boot";
	}
}
