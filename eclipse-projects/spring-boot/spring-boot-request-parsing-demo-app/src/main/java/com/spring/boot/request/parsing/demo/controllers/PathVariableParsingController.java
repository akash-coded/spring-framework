package com.spring.boot.request.parsing.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathVariableParsingDemo")
public class PathVariableParsingController {

	@GetMapping("/showId/{id}")
	public String showId(@PathVariable Integer id) {
		return "ID parsed from path variable: " + id;
	}
	
}
