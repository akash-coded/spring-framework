package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class Demo2Application {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	  return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}
	
	@GetMapping("/service-2")
	public String getValues() {
		return "Getting Called by Service 2";
	}
	
	@GetMapping("/service-2-1")
	public String callService1() {
		String val = restTemplate.getForObject("http://demo-1-app:8080/service-1", String.class);
		return "Service call from service 2 to service 1 --- " + val;
	}
}
