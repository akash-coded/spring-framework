package com.spring.boot.spring.security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityDemoApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApp.class, args);
		System.out.println("Spring Boot demo app with Spring Security works!");
	}

}
