package com.modernpublicschool.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.modernpublicschool.models.Student;

public class StudentMapper implements RowMapper<Student> {
	public Student mapRow(ResultSet result, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(result.getInt("id"));
		student.setName(result.getString("name"));
		student.setAge(result.getInt("age"));
		
		return student;
	}
}
