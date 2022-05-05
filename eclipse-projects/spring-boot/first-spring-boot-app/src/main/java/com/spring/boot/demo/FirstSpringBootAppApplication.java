package com.spring.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringBootAppApplication {

	public static void main(String[] args) {
		System.out.println("About to start the Spring Boot application...");
		SpringApplication.run(FirstSpringBootAppApplication.class, args);
	}

}
