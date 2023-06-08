package com.example.ecommerce.proxy;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;

@Component
public class UserServiceProxy implements UserService {
	private RestTemplate restTemplate;
	
	private static final String BACKEND_URL = "http://localhost:8089/users/";

	@Override
	public User getUserById(String userId) {
		ResponseEntity<User> response = restTemplate.getForEntity(BACKEND_URL + userId, User.class);
		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		} else {
			throw new RuntimeException("Failed to retrieve user");
		}
	}
}
