package com.spring.mysql.connector.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.mysql.connector.demo.controllers.CrudController;

public class MySqlConnectorApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		context.start();
		System.out.println("Spring JDBC app with MySQL Connector works!\n");
		
		CrudController crudController = context.getBean("crudController", CrudController.class);
		crudController.read();
		
		context.close();
	}

}
