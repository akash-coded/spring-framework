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
public class Demo1Application {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	  return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	@GetMapping("/service-1")
	public String getValues() {
		return "Getting Called by Service 1";
	}
	
	@GetMapping("/service-1-2")
	public String getValueFromService2() {
		String val = restTemplate.getForObject("http://demo-2-app:8080/service-2", String.class);
		return "Service call from service 1 to service 2 --- " + val;
	}

}
