package com.spring.boot.testing.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestingDemoApplication.class, args);
		System.out.println("Testing the Web Layer of a Spring Boot application!");
	}

}
