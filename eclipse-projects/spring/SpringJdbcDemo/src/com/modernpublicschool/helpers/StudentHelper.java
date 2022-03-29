package com.modernpublicschool.helpers;

import java.util.List;

import com.modernpublicschool.models.Student;

public class StudentHelper {
	public static void printAllStudents(List<Student> students) {
		for(Student student: students) {
			System.out.println("ID: " + student.getId());
			System.out.println("NAME: " + student.getName());
			System.out.println("AGE: " + student.getAge());
			System.out.println();
		}
	}
}
