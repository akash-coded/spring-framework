package com.spring.mysql.connector.n.tier.demo.models;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * 
 * @author Akash
 *
 * The Worker model class represents the structure of the worker table
 * 
 * One object of Worker model class will represent one record of the worker table
 * 
 */
public class Worker implements Comparable<Worker> {
	Integer workerId;
	String firstName;
	String lastName;
	Integer salary;
	Timestamp joiningDate;
	String department;
	
	public Worker() {
		super();
	}
	
	public Worker(Integer workerId, String firstName, String lastName, Integer salary, String department) {
		super();
		this.workerId = workerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.department = department;
	}

	public Worker(Integer workerId, String firstName, String lastName, Integer salary, Timestamp joiningDate,
			String department) {
		super();
		this.workerId = workerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.department = department;
	}

	public Integer getWorkerId() {
		return workerId;
	}

	public void setWorkerId(Integer workerId) {
		this.workerId = workerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Timestamp getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Timestamp joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, workerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(department, other.department) && Objects.equals(workerId, other.workerId);
	}
	
    @Override
    public int compareTo(Worker o) {
        if (this.workerId < o.workerId) {
            return -1;
        }
        if (this.workerId > o.workerId) {
            return 1;
        }
        if (this.equals(o)) {
            return 0;
        }
        return this.department.compareTo(o.department);
    }

	@Override
	public String toString() {
		return "Worker [workerId=" + workerId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
				+ salary + ", joiningDate=" + joiningDate + ", department=" + department + "]";
	}
}
