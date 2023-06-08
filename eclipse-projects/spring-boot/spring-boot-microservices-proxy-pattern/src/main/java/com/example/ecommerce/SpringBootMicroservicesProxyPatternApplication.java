package com.example.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaServer
@SpringBootApplication
public class SpringBootMicroservicesProxyPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservicesProxyPatternApplication.class, args);
	}

}
