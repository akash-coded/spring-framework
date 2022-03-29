package com.modernpublicschool;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.modernpublicschool.helpers.StudentHelper;
import com.modernpublicschool.models.Student;
import com.modernpublicschool.services.StudentJDBCTemplate;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		
		System.out.println("************** Records Creation **************");
		studentJDBCTemplate.create("Person One", 21);
		studentJDBCTemplate.create("Person Two", 15);
		studentJDBCTemplate.create("Person Three", 21);
		System.out.println();
		
		System.out.println("************** Displaying Student Records **************");
		List<Student> students = studentJDBCTemplate.getAllStudents(); 
		StudentHelper.printAllStudents(students);
	}
}
