package com.spring.jdbc.n.tier.demo.repositories;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.n.tier.demo.daos.WorkerDao;
import com.spring.jdbc.n.tier.demo.exceptions.DatabaseOperationException;
import com.spring.jdbc.n.tier.demo.mappers.WorkerRowMapper;
import com.spring.jdbc.n.tier.demo.models.Worker;

public class WorkerRepository implements WorkerDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Integer createWorker(Worker worker) throws DatabaseOperationException {
		String insertWorkerFormat = """
				INSERT INTO Worker (
				    WORKER_ID,
				    FIRST_NAME,
				    LAST_NAME,
				    SALARY,
				    JOINING_DATE,
				    DEPARTMENT)
				VALUES (
				    ?, ?, ?, ?, NOW(), ?
				    )""";

		Integer recordsInserted = 0;

		try {
			recordsInserted = jdbcTemplate.update(insertWorkerFormat, worker.getWorkerId(), worker.getFirstName(),
					worker.getLastName(), worker.getSalary(), worker.getDepartment());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while inserting a new worker record!", e);
		}

		return recordsInserted;
	}

	@Override
	public Worker findWorkerById(Integer id) throws DatabaseOperationException {
		String getWorkerFormat = """
				SELECT *
				FROM
				    Worker
				WHERE
				    WORKER_ID = ?""";

		Worker worker = null;

		try {
			worker = jdbcTemplate.queryForObject(getWorkerFormat, new WorkerRowMapper(), id);
		} catch (DataAccessException e) {
			throw new DatabaseOperationException(
					String.format("Exception occurred while fetching the record of worker with ID %d", id), e);
		}

		return worker;
	}

	@Override
	public Integer findWorkerCountByDepartment(String department) throws DatabaseOperationException {
		String getWorkerCountByDepartmentFormat = """
				SELECT COUNT(*)
				FROM
				    Worker
				WHERE
				    DEPARTMENT = ?""";

		Integer noOfWorkersInDepartment = 0;

		try {
			noOfWorkersInDepartment = jdbcTemplate.queryForObject(getWorkerCountByDepartmentFormat, Integer.class,
					department);
		} catch (DataAccessException e) {
			throw new DatabaseOperationException(
					String.format("Exception occurred while fetching all workers of %s department", department), e);
		}

		return noOfWorkersInDepartment;
	}

	@Override
	public List<Worker> findWorkersByDepartement(String department) throws DatabaseOperationException {
		String getDepartmentWorkersFormat = """
				SELECT *
				FROM
				    Worker
				WHERE
				    DEPARTMENT = ?""";

		List<Worker> workers = Collections.emptyList();

		try {
			workers = jdbcTemplate.query(getDepartmentWorkersFormat, new WorkerRowMapper(), department);
		} catch (DataAccessException e) {
			throw new DatabaseOperationException(
					String.format("Exception occurred while fetching all workers of %s department", department), e);
		}

		return workers;
	}

	@Override
	public List<Worker> findAllWorkers() throws DatabaseOperationException {
		String getWorkersFormat = """
				SELECT *
				FROM
				    Worker""";

		List<Worker> workers = Collections.emptyList();

		try {
			workers = jdbcTemplate.query(getWorkersFormat, new WorkerRowMapper());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException("Exception occurred while fetching all worker records", e);
		}

		return workers;
	}

	@Override
	public Integer updateWorker(Worker worker) throws DatabaseOperationException {
		String updateWorkerFormat = """
				UPDATE Worker
				SET
				    WORKER_ID = ?,
				    FIRST_NAME = ?,
				    LAST_NAME = ?,
				    SALARY = ?,
				    JOINING_DATE = ?,
				    DEPARTMENT = ?
				WHERE
				    WORKER_ID = ?""";

		Integer recordsUpdated = 0;

		try {
			recordsUpdated = jdbcTemplate.update(updateWorkerFormat, worker.getWorkerId(), worker.getFirstName(),
					worker.getLastName(), worker.getSalary(), worker.getJoiningDate(), worker.getDepartment(),
					worker.getWorkerId());
		} catch (DataAccessException e) {
			throw new DatabaseOperationException(
					String.format("Exception occurred while updating the record of worker with ID %d", worker.getWorkerId()), e);
		}

		return recordsUpdated;
	}

	@Override
	public Integer updateSalaryByDepartment(String department, Integer bonusFactor) throws DatabaseOperationException {
		String updateSalaryByDepartmentFormat = """
				UPDATE Worker
				SET
				    SALARY = SALARY * ?
				WHERE
				    DEPARTMENT = ?""";
		
		Integer recordsUpdated = 0;

		try {
			recordsUpdated = jdbcTemplate.update(updateSalaryByDepartmentFormat, bonusFactor, department);
		} catch (DataAccessException e) {
			throw new DatabaseOperationException(
					String.format("Exception occurred while updating all workers of %s department", department), e);
		}

		return recordsUpdated;
	}

	@Override
	public Integer deleteWorkerById(Integer id) throws DatabaseOperationException {
		String deleteWorkerFormat = """
				DELETE FROM Worker
				WHERE
				    WORKER_ID = ?""";
		
		Integer recordsUpdated = 0;

		try {
			recordsUpdated = jdbcTemplate.update(deleteWorkerFormat, id);
		} catch (DataAccessException e) {
			throw new DatabaseOperationException(
					String.format("Exception occurred while deleting the record of worker with ID %d", id), e);
		}

		return recordsUpdated;
	}
}
