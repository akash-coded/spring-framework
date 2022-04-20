package com.spring.maven.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.maven.demo.beans.User;

public class MavenApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		context.start();
		System.out.println("Our Spring Maven app works!");
		
		User user = context.getBean("user", User.class);	
		user.greetUser();
		
		context.close();
	}

}
