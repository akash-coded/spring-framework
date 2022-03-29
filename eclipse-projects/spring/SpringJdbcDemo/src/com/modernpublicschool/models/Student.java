package com.modernpublicschool.models;

public class Student {
	private int id;
	private String name;
	private int age;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}

//SpringJdbcDemo
// |-------- src
// 			|----com.modernpublicschool
// 					|----------------------models
// 					|						|-------Student.java
// 					|
// 					|----------------------dao
// 					|                       |-------StudentDAO.java
// 					|
// 					|----------------------services
// 					|                       |-------StudentJDBCTemplate.java
// 					|
// 					|----------------------mappers
// 					|						|-------StudentMapper.java
//					|
//					|----------------------helpers
//					|						|-------StudentHelper.java
// 					|
// 					|----------------------MainApp.java
// 			|----Beans.xml