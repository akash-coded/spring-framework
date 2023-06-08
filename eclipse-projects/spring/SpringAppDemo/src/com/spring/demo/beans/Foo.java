package com.spring.demo.beans;

public class Foo {
	
	private String name;
	
	
	/**
	 * 
	 */
	public Foo() {}


	/**
	 * @param name
	 */
	public Foo(String name) {
		this.name = name;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Foo [name=" + name + "]";
	}
	
}
