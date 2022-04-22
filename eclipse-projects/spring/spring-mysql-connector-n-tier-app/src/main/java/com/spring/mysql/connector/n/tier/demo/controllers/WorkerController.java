package com.spring.mysql.connector.n.tier.demo.controllers;

import java.sql.SQLException;
import java.util.List;

import com.spring.mysql.connector.n.tier.demo.models.Worker;
import com.spring.mysql.connector.n.tier.demo.services.WorkerService;

public class WorkerController {
	private WorkerService workerService;
	
	WorkerController(WorkerService workerService) {
		this.workerService = workerService;
	}
	
	public String create(Integer id, String firstName, String lastName, Integer salary, String department) {
		Worker worker = new Worker(id, firstName, lastName, salary, department);
		try {
			if (Boolean.TRUE.equals(this.workerService.addWorker(worker))) {
				return "New worker record added successfully";
			} 
		} catch (SQLException ex) {
			System.out.println("Exception occurred while inserting a new worker record!\n" + ex);
		}
		
		return "Failure in inserting new worker record!";
	}
	
	public String get(Integer id) {
		try {
			Worker worker = this.workerService.getWorker(id);
			return worker == null ? "Empty set!" : worker.toString();
		} catch (SQLException ex) {
			System.out.println("Exception occurred while fetching the record of worker #" + id + "!\n" + ex);
		}
		
		return null;
	}
	
	public String getAll() {
		try {
			List<Worker> workers = this.workerService.getAllWorkers();
			
			return workers.isEmpty() ? "Empty set!" : workers.toString();
		} catch (SQLException ex) {
			System.out.println("Exception occurred while fetching all worker records!\n" + ex);
		}
		
		return null;
	}
	
	public String update(String department, Integer id) {
		try {
			if (Boolean.TRUE.equals(this.workerService.updateWorker(department, id))) {
				return String.format("Record of worker #%d updated successfully", id);
			} 
		} catch (SQLException ex) {
			System.out.println("Exception occurred while updating the record of worker #" + id + "!\n" + ex);
		}
		
		return String.format("Failure in updating the record of worker #%d!", id);
	}
	
	public String delete(Integer id) {
		try {
			if (Boolean.TRUE.equals(this.workerService.deleteWorker(id))) {
				return String.format("Record of worker #%d deleted successfully", id);
			} 
		} catch (SQLException ex) {
			System.out.println("Exception occurred while deleting the record of worker #" + id + "!\n" + ex);
		}
		
		return String.format("Failure in deleting the record of worker #%d!", id);
	}
}
