package com.example.service.resource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.resource.dto.UserDetailsDTO;
import com.example.service.resource.feignService.UserServiceFeign;

@RestController
@RequestMapping("/api")
public class UserResourceController {
	
	@Autowired
	private UserServiceFeign userServiceFeign;
	
	@PostMapping("/saveUpdate")
	public UserDetailsDTO saveUpdate(UserDetailsDTO inputUser) {
		return userServiceFeign.saveUpdate(inputUser);
	}
	
	@GetMapping("/getById/{id}")
	public UserDetailsDTO getUserById(@PathVariable Long id) {
		return userServiceFeign.getUserById(id);
	}
	
	@GetMapping("/getByName/{name}")
	public List<UserDetailsDTO> getUserByName(@PathVariable String name) {
		return userServiceFeign.getUserByName(name);
	}
}
