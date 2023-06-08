/**
 * 
 */
package com.spring.crud.demo.controller;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.spring.crud.demo.model.User;

/**
 * @author Akash
 * 
 *         User CRUD Controller
 *
 */
public class UserController {

	ConcurrentMap<Integer, User> users = new ConcurrentHashMap<>();

	// CREATE operation
	public String addUser(User user) {
		users.put(user.getId(), user);

		return "User with ID" + user.getId() + " added successfully.";
	}

	// READ(RETRIEVE) operation
	public User getUser(Integer id) {
		return users.get(id);
	}

	public List<User> getAllUsers() {
		return users.values().stream().toList();
	}

	// UPDATE operation
	public String updateUser(Integer id, String name) {
		User targetUser = users.get(id);
		targetUser.setName(name);
		users.put(id, targetUser);

		return "User with the ID " + id + " updated successfully!";
	}

	// DELETE single user
	public String deleteUser(Integer id) {
		users.remove(id);

		return "User with the ID " + id + " deleted successfully!";
	}

	// DELETE all users
	public String deleteAllUsers() {
		users.clear();

		return "All Users deleted successfully!";
	}

}
