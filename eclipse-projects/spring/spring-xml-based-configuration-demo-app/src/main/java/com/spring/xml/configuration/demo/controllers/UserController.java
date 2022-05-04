package com.spring.xml.configuration.demo.controllers;

import com.spring.xml.configuration.demo.services.UserService;

public class UserController {

	private UserService userService;
	
	UserController(UserService userService) {
		this.userService = userService;
	}
	
	public void send(String message) {
		userService.sendMessage(message);
	}
	
	public void create(String name) {
		userService.addUser(name);
	}

	public String get(String name) {
		return userService.getUserDetails(name).toString();
	}

}
