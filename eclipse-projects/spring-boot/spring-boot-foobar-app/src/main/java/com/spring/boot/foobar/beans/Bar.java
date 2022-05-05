package com.spring.boot.foobar.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bar {
	@Value("Arthur")
	private String name;
	
	@Value("${bar.age:30}")
	private int age;
	
	@Autowired
	private Foo foo;
	
	public Bar() {
		super();
	}

	public Bar(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void setFoo(Foo foo) {
		this.foo = foo;
	}
	
	public String processName() {
		return foo.getName();
	}

	@Override
	public String toString() {
		return "Bar [name=" + name + ", age=" + age + ", foo=" + foo + "]";
	}
}
