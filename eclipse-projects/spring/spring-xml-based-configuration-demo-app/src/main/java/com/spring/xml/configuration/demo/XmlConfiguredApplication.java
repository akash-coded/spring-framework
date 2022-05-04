package com.spring.xml.configuration.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.xml.configuration.demo.controllers.UserController;

public class XmlConfiguredApplication {

	public static void main(String...args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Obtaining an instance of UserController
		UserController userController = context.getBean(UserController.class);
		
		// Sending an SMS
		userController.send("Demonstrating Annotation-Based Configuration in a Spring application");
		
		// Creating a new User
		userController.create("Akash");
		
		// Printing the details of a User
		System.out.println(userController.get("Akash")); 
		
		context.close();
	}
	
}
