package com.spring.xml.configuration.demo.services;

import com.spring.xml.configuration.demo.models.User;
import com.spring.xml.configuration.demo.repositories.UserRepository;
import com.spring.xml.configuration.demo.utils.SendSmsUtil;

public class UserService {
	
	private SendSmsUtil demoUtil;
	private UserRepository userRepository;
	
	public void setDemoUtil(SendSmsUtil demoUtil) {
		this.demoUtil = demoUtil;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void sendMessage(String message) {
		this.demoUtil.sendSms(message);
	}
	
	public void addUser(String name) {
		User user = new User(name);
		this.userRepository.createUser(user);
	}
	
	public User getUserDetails(String name) {
		return this.userRepository.findUser(name);
	}

}
