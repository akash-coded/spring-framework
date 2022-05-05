package com.spring.java.configuration.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.java.configuration.demo.beans.Bar;
import com.spring.java.configuration.demo.beans.Foo;

public class JavaConfiguredApplication {
	
	public static void main(String...args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		
		System.out.println("Spring foobar app with Java-based configuration runs!");
		
		Foo f = context.getBean(Foo.class);
		System.out.println(f);
		
		Bar b = context.getBean(Bar.class);
		System.out.println(b);
		
		context.close();		
	}
	
}
