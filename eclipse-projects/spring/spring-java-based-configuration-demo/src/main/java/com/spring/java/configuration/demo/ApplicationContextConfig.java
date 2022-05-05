package com.spring.java.configuration.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.spring.java.configuration.demo.beans.Bar;
import com.spring.java.configuration.demo.beans.Foo;

@Configuration
public class ApplicationContextConfig {
	
	@Bean
	@Scope("prototype")
	public Foo fooComponent() {
		return new Foo("Cleopatra");
	}
	
	@Bean
	public Bar barComponent() {
		Bar b = new Bar("Arthur", 26);
		b.setFoo(fooComponent());
		return b;
	}
	
}
