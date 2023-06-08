package com.example.service.resource.feignService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.service.resource.dto.UserDetailsDTO;

@FeignClient(name = "user-service")
public interface UserServiceFeign {

	@PostMapping("/api/saveUpdate")
	UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser);
	
	@GetMapping("/api/getById/{id}")
	UserDetailsDTO getUserById(@PathVariable Long id);
	
	@GetMapping("/api/getByName/{name}")
	List<UserDetailsDTO> getUserByName(@PathVariable String name);
	
}
