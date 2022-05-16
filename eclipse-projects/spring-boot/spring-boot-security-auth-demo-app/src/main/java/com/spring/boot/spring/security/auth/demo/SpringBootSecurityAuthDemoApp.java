package com.spring.boot.spring.security.auth.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityAuthDemoApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityAuthDemoApp.class, args);
		System.out.println("Spring Boot demo app with Spring Security authentication and authorization works!");
		;
	}

}
