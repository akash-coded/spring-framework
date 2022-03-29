package com.modernpublicschool.dao;

import java.util.List;

import javax.sql.DataSource;

import com.modernpublicschool.models.Student;

public interface StudentDAO {
	/**
	 * It is used to initialize the DB connection
	 * 
	 * @param ds DataSource
	 */
	public void setDataSource(DataSource dataSource);
	
	/**
	 * Create a student record
	 * 
	 * @param name String
	 * @param age Integer
	 */

	public void create(String name, Integer age);
	
	/**
	 * Fetches a student record corresponding to the student id
	 * 
	 * @param id Integer
	 * @return Student
	 */

	public Student getStudentById(Integer id);
	
	/**
	 * Lists down all student records
	 * 
	 * @return List<Student>
	 */
	public List<Student> getAllStudents();
	
	/**
	 * Updates a student's age based on their id
	 * 
	 * @param id Integer
	 * @param age Integer
	 */
	public void update(Integer id, Integer age);
	
	/**
	 * Deletes a student record based on their id
	 * 
	 * @param id Integer
	 */
	public void delete(Integer id);
}
