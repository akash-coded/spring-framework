package com.modernpublicschool.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.modernpublicschool.dao.StudentDAO;
import com.modernpublicschool.mappers.StudentMapper;
import com.modernpublicschool.models.Student;

public class StudentJDBCTemplate implements StudentDAO {
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(String name, Integer age) {
		String sql = "INSERT INTO students (" +
				"name, age" +
				") VALUES (" +
				"?, ?" +
				")";
		
		jdbcTemplateObject.update(sql, name, age);
		
		System.out.println("Student " + name + "'s record inserted successfully");
		return;
	}
	
	public Student getStudentById(Integer id) {
		String sql = "SELECT * FROM students WHERE id = ?";
		Student student = jdbcTemplateObject.queryForObject(
				sql, 
				new Object[] {id}, 
				new StudentMapper()
				);
		
		return student;
	}
	
	public List<Student> getAllStudents() {
		String sql = "SELECT * FROM students";
		List<Student> students = jdbcTemplateObject.query(
				sql, 
				new StudentMapper()
				);
		
		return students;
	}
	
	public void update(Integer id, Integer age) {
		String sql = "UPDATE students SET age = ? WHERE id = ?";
		jdbcTemplateObject.update(sql, age, id);
		System.out.println("Record #" + id + "'s age updated to " + age);
		return;
	}
	
	public void delete(Integer id) {
		String sql = "DELETE FROM students WHERE id = ?";
		jdbcTemplateObject.update(sql, id);
		System.out.println("Record #" + id + " deleted");
		return;
	}
}
