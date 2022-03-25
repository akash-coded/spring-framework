package com.springdemo;

import org.springframework.context.annotation.*;

@Configuration
//@Import(HelloWorldConfig1.class)
public class HelloWorldConfig {
	@Bean
	public HelloWorld helloWorld2() {
		return new HelloWorld();
	}
	
	@Bean
	@Scope("prototype")
	public HelloIndia helloIndia2() {
		return new HelloIndia();
	}
}
