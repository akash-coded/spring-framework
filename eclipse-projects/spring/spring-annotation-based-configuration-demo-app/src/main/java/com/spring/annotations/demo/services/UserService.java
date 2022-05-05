package com.spring.annotations.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.annotations.demo.models.User;
import com.spring.annotations.demo.repositories.UserRepository;
import com.spring.annotations.demo.utils.SendSmsUtil;

@Service
public class UserService {
	
	@Autowired // uses setter injection
	private SendSmsUtil demoUtil;
	
	@Autowired
	private UserRepository userRepository;
	
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
