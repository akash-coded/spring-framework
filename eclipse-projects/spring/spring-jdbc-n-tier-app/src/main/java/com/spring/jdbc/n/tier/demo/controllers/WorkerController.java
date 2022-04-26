package com.spring.jdbc.n.tier.demo.controllers;

import com.spring.jdbc.n.tier.demo.exceptions.MyResourceNotCreatedException;
import com.spring.jdbc.n.tier.demo.exceptions.MyResourceNotDeletedException;
import com.spring.jdbc.n.tier.demo.exceptions.MyResourceNotFoundException;
import com.spring.jdbc.n.tier.demo.exceptions.MyResourceNotUpdatedException;
import com.spring.jdbc.n.tier.demo.models.Worker;
import com.spring.jdbc.n.tier.demo.services.WorkerService;

public class WorkerController {
	
	private WorkerService workerService;

	WorkerController(WorkerService workerService) {
		this.workerService = workerService;
	}

	public String create(Integer id, String firstName, String lastName, Integer salary, String department) {
		Worker worker = new Worker(id, firstName, lastName, salary, department);

		try {
			this.workerService.addWorker(worker);
			return "New worker record created successfully.";
		} catch (MyResourceNotCreatedException e) {
			return e.getMessage();
		}
	}

	public String get(Integer id) {
		try {
			return this.workerService.getWorker(id).toString();
		} catch (MyResourceNotFoundException e) {
			return e.getMessage();
		}
	}

	public String getAll() {
		try {
			return this.workerService.getAllWorkers().toString();

		} catch (MyResourceNotFoundException e) {
			return e.getMessage();
		}
	}

	public String getDepartmentWorkers(String department) {
		try {
			return this.workerService.getWorkersByDepartment(department).toString();
		} catch (MyResourceNotFoundException e) {
			return e.getMessage();
		}
	}

	public String update(Integer id, String department) {
		try {
			this.workerService.updateWorker(id, department);

			return String.format("Record of worker with ID %d updated successfully.", id);
		} catch (MyResourceNotFoundException | MyResourceNotUpdatedException e) {
			return e.getMessage();
		}
	}

	public String updateSalaryForDepartment(String department, Integer bonusFactor) {
		try {
			this.workerService.updateDepartmentWorkerSalaries(department, bonusFactor);

			return String.format("Updated the salaries of all %s department workers.", department);
		} catch (MyResourceNotUpdatedException e) {
			return e.getMessage();
		}
	}

	public String delete(Integer id) {
		try {
			this.workerService.deleteWorker(id);
			
			return String.format("Record of worker with ID %d deleted successfully", id);
		} catch (MyResourceNotDeletedException e) {
			return e.getMessage();
		}
	}
	
}
