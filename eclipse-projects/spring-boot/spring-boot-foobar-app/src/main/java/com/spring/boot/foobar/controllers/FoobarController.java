package com.spring.boot.foobar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.foobar.beans.Bar;
import com.spring.boot.foobar.beans.Foo;

@RestController
@RequestMapping("/api/beans")
public class FoobarController {
	
	@Autowired
	private Foo foo;
	
	@Autowired
	private Bar bar;

	@GetMapping("/foo")
	public Foo getFoo() {
		return foo;
	}
	
	@GetMapping("/bar")
	public String getBar() {
		return bar.toString();
	}
}
