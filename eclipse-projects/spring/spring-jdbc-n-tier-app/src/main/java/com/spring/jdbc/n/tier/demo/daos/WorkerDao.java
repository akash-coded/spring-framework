package com.spring.jdbc.n.tier.demo.daos;

import java.util.List;

import javax.sql.DataSource;

import com.spring.jdbc.n.tier.demo.exceptions.DatabaseOperationException;
import com.spring.jdbc.n.tier.demo.models.Worker;

public interface WorkerDao {
	
	// Required by Spring JDBC to connect with the DB
	void setDataSource(DataSource ds);
	
	// Create Operation
	Integer createWorker(Worker worker) throws DatabaseOperationException;
	
	// Read/Retrieve Operations
	Worker findWorkerById(Integer id) throws DatabaseOperationException;
	Integer findWorkerCountByDepartment(String department) throws DatabaseOperationException;
	List<Worker> findWorkersByDepartement(String department) throws DatabaseOperationException;
	List<Worker> findAllWorkers() throws DatabaseOperationException;
	
	// Update Operations
	Integer updateWorker(Worker worker) throws DatabaseOperationException;
	Integer updateSalaryByDepartment(String department, Integer bonusFactor) throws DatabaseOperationException;
	
	// Delete Operations
	Integer deleteWorkerById(Integer id) throws DatabaseOperationException;	
}
