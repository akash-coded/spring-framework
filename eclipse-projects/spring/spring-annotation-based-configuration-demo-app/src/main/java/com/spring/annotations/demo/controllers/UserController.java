package com.spring.annotations.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.annotations.demo.services.UserService;

@Controller
public class UserController {

	private UserService userService;
	
	@Autowired // uses constructor injection
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
