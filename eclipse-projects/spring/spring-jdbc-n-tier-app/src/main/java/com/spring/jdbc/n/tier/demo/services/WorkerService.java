package com.spring.jdbc.n.tier.demo.services;

import java.util.List;
import java.util.Objects;

import com.spring.jdbc.n.tier.demo.daos.WorkerDao;
import com.spring.jdbc.n.tier.demo.exceptions.DatabaseOperationException;
import com.spring.jdbc.n.tier.demo.exceptions.MyResourceNotCreatedException;
import com.spring.jdbc.n.tier.demo.exceptions.MyResourceNotDeletedException;
import com.spring.jdbc.n.tier.demo.exceptions.MyResourceNotFoundException;
import com.spring.jdbc.n.tier.demo.exceptions.MyResourceNotUpdatedException;
import com.spring.jdbc.n.tier.demo.models.Worker;

public class WorkerService {
	private WorkerDao workerRepository;

	WorkerService(WorkerDao workerRepository) {
		super();
		this.workerRepository = workerRepository;
	}

	public void addWorker(Worker worker) throws MyResourceNotCreatedException {
		try {
			Integer recordsInserted = this.workerRepository.createWorker(worker);

			if (recordsInserted == 0) {
				throw new MyResourceNotCreatedException("Could not create new worker record!");
			}
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotCreatedException("Something went wrong when creating new worker record!");
		}
	}

	public Worker getWorker(Integer id) throws MyResourceNotFoundException {
		try {
			Worker worker = this.workerRepository.findWorkerById(id);

			if (worker == null) {
				throw new MyResourceNotFoundException(String.format("No worker found with ID %d!", id));
			}
			
			return worker;
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotFoundException("Something went wrong when fetching the worker record!");
		}
	}

	public List<Worker> getWorkersByDepartment(String department) throws MyResourceNotFoundException {
		try {
			List<Worker> workers = this.workerRepository.findWorkersByDepartement(department);

			if (workers.isEmpty()) {
				throw new MyResourceNotFoundException("No workers found in the department!");
			}
			
			return workers;
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotFoundException(String
					.format("Something went wrong when fetching the worker records of department %s!", department));
		}
	}

	public List<Worker> getAllWorkers() throws MyResourceNotFoundException {
		try {
			List<Worker> workers = this.workerRepository.findAllWorkers();

			if (workers.isEmpty()) {
				throw new MyResourceNotFoundException("No workers found!");
			}
			
			return workers;
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotFoundException("Something went wrong when fetching the worker records!");
		}
	}

	public void updateWorker(Integer id, String department)
			throws MyResourceNotFoundException, MyResourceNotUpdatedException {
		try {
			Worker worker = this.workerRepository.findWorkerById(id);
			if (worker == null) {
				throw new MyResourceNotFoundException(String.format("No worker found with ID %d!", id));
			}
			worker.setDepartment(department);
			Integer recordsUpdated = this.workerRepository.updateWorker(worker);
			if (recordsUpdated == 0) {
				throw new MyResourceNotUpdatedException(String.format("Details of worker with ID %d not updated!", id));
			}
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotUpdatedException("Something went wrong when updating the worker record");
		}
	}

	public void updateDepartmentWorkerSalaries(String department, Integer bonusFactor)
			throws MyResourceNotUpdatedException {
		try {
			Integer recordsUpdated = this.workerRepository.updateSalaryByDepartment(department, bonusFactor);
			if (recordsUpdated == 0) {
				throw new MyResourceNotUpdatedException(
						String.format("Salary of %s department workers not updated!", department));
			}
			Integer workerCountInDepartment = this.workerRepository.findWorkerCountByDepartment(department);
			if (!Objects.equals(recordsUpdated, workerCountInDepartment)) {
				throw new MyResourceNotUpdatedException(
						String.format("Could not update the salaries of all %s department workers!", department));
			}
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotUpdatedException("Something went wrong when updating the worker records");
		}
	}

	public void deleteWorker(Integer id) throws MyResourceNotDeletedException {
		try {
			Integer recordsDeleted = this.workerRepository.deleteWorkerById(id);
			if(recordsDeleted == 0) {
				throw new MyResourceNotDeletedException(String.format("Worker record with ID %d not deleted!", id));
			}
		} catch (DatabaseOperationException e) {
			e.printStackTrace();
			throw new MyResourceNotDeletedException("Something went wrong when deleting the worker record");
		}
	}
}
