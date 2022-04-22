package com.spring.mysql.connector.n.tier.demo.services;

import java.sql.SQLException;
import java.util.List;

import com.spring.mysql.connector.n.tier.demo.daos.WorkerDao;
import com.spring.mysql.connector.n.tier.demo.models.Worker;

public class WorkerService {
	private WorkerDao workerRepository;
	
	WorkerService(WorkerDao workerRepository) {
		super();
		this.workerRepository = workerRepository;
	}
	
	public Boolean addWorker(Worker worker) throws SQLException {
		Integer recordsInserted = this.workerRepository.createWorker(worker);
		
		return recordsInserted > 0;
	}
	
	public Worker getWorker(Integer id) throws SQLException {
		return this.workerRepository.findWorkerById(id);
	}
	
	public List<Worker> getAllWorkers() throws SQLException {
		return this.workerRepository.findAllWorkers();
	}
	
	public Boolean updateWorker(String department, Integer id) throws SQLException {
		Worker worker = this.workerRepository.findWorkerById(id);
		worker.setDepartment(department);
		Integer recordsUpdated = this.workerRepository.updateWorker(worker);
		
		return recordsUpdated > 0;
	}
	
	public Boolean deleteWorker(Integer id) throws SQLException {
		Integer recordsDeleted = this.workerRepository.deleteWorkerById(id);
		
		return recordsDeleted > 0;
	}
}
