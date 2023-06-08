package com.example.service.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.user.dto.UserDetailsDTO;
import com.example.service.user.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/saveUpdate")
	public UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser) {
		return userService.saveUpdate(inputUser);
	}
	
	@GetMapping(value = "/getById/{id}")
	public UserDetailsDTO getUserById(@PathVariable Long id) {
		return userService.getById(id);
	}
	
	@GetMapping(value = "/getByName/{name}")
	public List<UserDetailsDTO> getUserByName(@PathVariable String name) {
		return userService.getByName(name)
;	}
}
