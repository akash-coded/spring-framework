package com.spring.annotations.demo.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.annotations.demo.models.User;

@Repository
public class UserRepository {
	List<User> users = Collections.synchronizedList(new ArrayList<>());

	public void createUser(User user) {
		users.add(user);
	}
	
	public User findUser(String name) {
		return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
	}
	
	public List<User> getAllUsers() {
		return users;
	}
}
