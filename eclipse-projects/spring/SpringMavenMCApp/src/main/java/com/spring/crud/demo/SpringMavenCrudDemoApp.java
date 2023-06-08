/**
 * 
 */
package com.spring.crud.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.crud.demo.controller.UserController;
import com.spring.crud.demo.model.User;

/**
 * @author Akash
 *
 */
public class SpringMavenCrudDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context-config.xml");
		System.out.println("My Spring application runs!\n");
		
		UserController controller = context.getBean("userController", UserController.class);
		
		// CREATE operation
		System.out.println(controller.addUser(new User(101, "Akash", "9987654321")));
		System.out.println(controller.addUser(new User(102, "John", "9987654322")));
		System.out.println(controller.addUser(new User(103, "Keith", "9987654323")));
		System.out.println(controller.addUser(new User(104, "Orlando", "9987654324")));
		System.out.println();
		
		// READ operations
		System.out.println(controller.getAllUsers());
		System.out.println(controller.getUser(101));
		System.out.println();
		
		// UPDATE operation
		System.out.println(controller.updateUser(102, "Jeremiah"));
		System.out.println();
		
		// DELETE operations
		System.out.println(controller.deleteUser(103));
		System.out.println(controller.getAllUsers());
		System.out.println(controller.deleteAllUsers());
		System.out.println();
		
		System.out.println("Closing the application...");
		context.close();
		
	}

}
