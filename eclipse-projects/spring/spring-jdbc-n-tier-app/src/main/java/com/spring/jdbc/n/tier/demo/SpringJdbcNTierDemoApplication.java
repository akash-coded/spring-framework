package com.spring.jdbc.n.tier.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.n.tier.demo.controllers.WorkerController;

public class SpringJdbcNTierDemoApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		context.start();
		System.out.println("Spring JDBC app with custom exception handling works!\n");
		
		WorkerController workerController = context.getBean("workerController", WorkerController.class);
		
		System.out.println("Creating a new worker record::");
		System.out.println(workerController.create(10, "Tony", "Stark", 50000000, "R&D"));
		System.out.println();
		
		System.out.println("Retrieving a worker record::");
		System.out.println(workerController.get(10));
		System.out.println();
		
		System.out.println("Retrieving all worker records::");
		String allWorkerDetails = workerController.getAll();
		String[] workers = allWorkerDetails.substring(1, allWorkerDetails.length() - 1).split("Worker Details:");
		for(String workerDetails: workers) {
			System.out.println(workerDetails);
		}
		System.out.println();
		
		System.out.println("Updating a worker record::");
		System.out.println(workerController.update(10, "Boss"));
		System.out.println("Retrieving the worker record after updation::");
		System.out.println(workerController.get(10));
		System.out.println();
		
		System.out.println("Updating the salaries of all workers of a department::");
		System.out.println(workerController.updateSalaryForDepartment("Boss", 2));
		System.out.println("Retrieving the department worker records after updation::");
		System.out.println(workerController.getDepartmentWorkers("Boss"));
		System.out.println();
		
		System.out.println("Deleting a worker record::");
		System.out.println(workerController.delete(10));
		System.out.println();
		
		context.close();
	}

}
