package com.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DeclarativeOpenfeignMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeclarativeOpenfeignMicroservicesApplication.class, args);
	}

}
