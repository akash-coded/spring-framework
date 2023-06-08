/**
 * 
 */
package com.spring.crud.demo.model;

/**
 * @author Akash
 *
 */
public class User {
	
	private Integer id;
	private String name;
	private String phoneNo;
	

	/**
	 * 
	 */
	public User() {}


	/**
	 * @param id
	 * @param name
	 * @param phoneNo
	 */
	public User(Integer id, String name, String phoneNo) {
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}


	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phoneNo=" + phoneNo + "]";
	}

}
