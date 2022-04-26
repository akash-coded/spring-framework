package com.spring.boot.swagger.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootSwaggerDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerDemoAppApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.spring.boot.swagger.demo"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Spring Boot Swagger Demo API",
				"Spring Boot demo application with Swagger",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Akash Das", "https://github.com/akash-coded/", "mfs.akash@gmail.com"),
				"API License",
				"https://github.com/akash-coded/",
				Collections.emptyList()
				);
	}

}
