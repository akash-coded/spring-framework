package com.spring.java.configuration.demo.beans;

public class Bar {
	private String name;
	private int age;
	private Foo foo;
	
	public Bar() {}

	public Bar(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setFoo(Foo foo) {
		this.foo = foo;
	}

	@Override
	public String toString() {
		return "Bar [name=" + name + ", age=" + age + ", foo=" + foo + "]";
	}	
}
