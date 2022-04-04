package com.springbootdemo.requesthandlingdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableHandlingDemoController {
	@GetMapping("/showPathVariable/{id}")
	public String showName(@PathVariable String id) {
		return "ID: " + id;
	}
}
