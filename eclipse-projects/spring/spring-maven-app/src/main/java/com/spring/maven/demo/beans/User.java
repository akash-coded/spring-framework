package com.spring.maven.demo.beans;

public class User {
	private String name;

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void greetUser() {
		System.out.println("Hello " + this.name);
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
}

