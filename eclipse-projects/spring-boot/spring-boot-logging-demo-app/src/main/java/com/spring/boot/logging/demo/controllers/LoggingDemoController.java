package com.spring.boot.logging.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingDemoController {
	private static final Logger log = LoggerFactory.getLogger(LoggingDemoController.class);
	
	@GetMapping("/loggingDemo")
	public String logDemoMessages() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "Pre-defined messages have been logged";
	}
	
	@GetMapping("/log")
	public String logMessage(@RequestParam String message) {
       log.info("Message received:: " + message);

        return "The following message has been logged: " + message;
	}
}
