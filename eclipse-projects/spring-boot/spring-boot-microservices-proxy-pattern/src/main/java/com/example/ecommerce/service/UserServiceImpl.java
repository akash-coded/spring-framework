package com.example.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.User;

@Service
@Primary
public class UserServiceImpl implements UserService {
	
	private List<User> users;
	
	public UserServiceImpl() {
		users = new ArrayList<>();
		users.add(new User("1", "John Doe", "john@example.com"));
		users.add(new User("2", "Jane Smith", "jane@example.com"));
	}

	@Override
	public User getUserById(String userId) {
		for (User user: users) {
			if(user.getId().equals(userId)) {
				return user;
			}
		}
		
		return null;
	}

}
