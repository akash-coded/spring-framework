package com.spring.xml.configuration.demo.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.spring.xml.configuration.demo.models.User;

public class UserRepository {
	List<User> users = Collections.synchronizedList(new ArrayList<>()); // for demonstration purposes

	public void createUser(User user) {
		users.add(user);
	}
	
	public User findUser(String name) {
		return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public void updateUser(String oldName, String newName) {
		Optional<User> userToBeUpdated = users.stream().filter(user -> user.getName().equals(oldName)).findFirst();
		
		if(userToBeUpdated.isPresent()) {
			userToBeUpdated.get().setName(newName);
		}
	}
	
	public void deleteUser(String name) {
		Optional<User> userToBeDeleted = users.stream().filter(user -> user.getName().equals(name)).findFirst();
		
		if(userToBeDeleted.isPresent()) {
			users.remove(userToBeDeleted.get());
		}
	}
}
