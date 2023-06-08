package com.spring.demo.beans;

public class Bar {
	
	private String name;
	private int age;
	private Foo foo;
	
	
	/**
	 * 
	 */
	public Bar() {}


	/**
	 * @param name
	 * @param age
	 */
	public Bar(String name, int age) {
		this.name = name;
		this.age = age;
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


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * @return the foo
	 */
	public Foo getFoo() {
		return foo;
	}


	/**
	 * @param foo the foo to set
	 */
	public void setFoo(Foo foo) {
		this.foo = foo;
	}


	@Override
	public String toString() {
		return "Bar [name=" + name + ", age=" + age + ", foo=" + foo + "]";
	}

}
