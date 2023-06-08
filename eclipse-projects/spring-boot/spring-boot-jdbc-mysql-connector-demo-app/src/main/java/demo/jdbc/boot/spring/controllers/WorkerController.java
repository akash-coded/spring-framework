/**
 * 
 */
package demo.jdbc.boot.spring.controllers;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.jdbc.boot.spring.models.Worker;
import demo.jdbc.boot.spring.service.WorkerService;

/**
 * @author Akash
 * 
 * Worker CRUD controller for this REST API
 *
 */
@RestController
@RequestMapping("/worker")
public class WorkerController {
	private WorkerService workerService;
	
	@Autowired
	WorkerController(WorkerService workerService) {
		this.workerService = workerService;
	}
	
	@PostMapping("")
	public String create(@RequestBody Worker worker) {
		try {
			if (Boolean.TRUE.equals(this.workerService.addWorker(worker))) {
				return "New worker record added successfully";
			} 
		} catch (SQLException ex) {
			System.out.println("Exception occurred while inserting a new worker record!\n" + ex);
		}
		
		return "Failure in inserting new worker record!";
	}
	
	@GetMapping("/{id}")
	public Worker get(@PathVariable Integer id) {
		try {
			return this.workerService.getWorker(id);
		} catch (SQLException ex) {
			System.out.println("Exception occurred while fetching the record of worker #" + id + "!\n" + ex);
		}
		
		return null;
	}
	
	@GetMapping("/all")
	public List<Worker> getAll() {
		try {
			return this.workerService.getAllWorkers();
		} catch (SQLException ex) {
			System.out.println("Exception occurred while fetching all worker records!\n" + ex);
		}
		
		return Collections.emptyList();
	}
	
	@PatchMapping("/{id}")
	public String update(@PathVariable Integer id, @RequestBody Worker worker) {
		try {
			if (Boolean.TRUE.equals(this.workerService.updateWorker(id, worker))) {
				return String.format("Record of worker #%d updated successfully", id);
			} 
		} catch (SQLException ex) {
			System.out.println("Exception occurred while updating the record of worker #" + id + "!\n" + ex);
		}
		
		return String.format("Failure in updating the record of worker #%d!", id);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
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
