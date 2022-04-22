package com.spring.mysql.connector.n.tier.demo.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spring.mysql.connector.n.tier.demo.utils.DatabaseConnection;
import com.spring.mysql.connector.n.tier.demo.daos.WorkerDao;
import com.spring.mysql.connector.n.tier.demo.models.Worker;

public class WorkerRepository implements WorkerDao {
	private final Connection connection;

	public WorkerRepository(DatabaseConnection connection) {
		super();
		this.connection = connection.getConnection();
	}

	@Override
	public Integer createWorker(Worker worker) throws SQLException {
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

		try (PreparedStatement preparedStatement = connection.prepareStatement(insertWorkerFormat);) {
			preparedStatement.setInt(1, worker.getWorkerId());
			preparedStatement.setString(2, worker.getFirstName());
			preparedStatement.setString(3, worker.getLastName());
			preparedStatement.setInt(4, worker.getSalary());
			preparedStatement.setString(5, worker.getDepartment());
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Worker findWorkerById(Integer id) throws SQLException {
		// Read (Retrieve) Operation using PreparedStatement
		String getWorkerFormat = """
				SELECT *
				FROM
				    Worker
				WHERE
				    WORKER_ID = ?""";
		try (PreparedStatement preparedStatement = connection.prepareStatement(getWorkerFormat);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			Worker worker = new Worker();
			while (rs.next()) {
				worker.setWorkerId(rs.getInt("WORKER_ID"));
				worker.setFirstName(rs.getString("FIRST_NAME"));
				worker.setLastName(rs.getString("LAST_NAME"));
				worker.setSalary(rs.getInt("SALARY"));
				worker.setJoiningDate(rs.getTimestamp("JOINING_DATE"));
				worker.setDepartment(rs.getString("DEPARTMENT"));
			}
			return worker;
		}
	}

	@Override
	public List<Worker> findAllWorkers() throws SQLException {
		String getWorkersFormat = """
				SELECT *
				FROM
				    Worker""";
		try (PreparedStatement preparedStatement = connection.prepareStatement(getWorkersFormat);) {
			ResultSet rs = preparedStatement.executeQuery();
			List<Worker> workers = new ArrayList<>();

			if (!rs.isBeforeFirst()) {
				return workers;
			}

			while (rs.next()) {
				Worker worker = new Worker();
				worker.setWorkerId(rs.getInt("WORKER_ID"));
				worker.setFirstName(rs.getString("FIRST_NAME"));
				worker.setLastName(rs.getString("LAST_NAME"));
				worker.setSalary(rs.getInt("SALARY"));
				worker.setJoiningDate(rs.getTimestamp("JOINING_DATE"));
				worker.setDepartment(rs.getString("DEPARTMENT"));

				workers.add(worker);
			}

			return workers;
		}
	}

	@Override
	public Integer updateWorker(Worker worker) throws SQLException {
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

		try (PreparedStatement preparedStatement = connection.prepareStatement(updateWorkerFormat);) {
			preparedStatement.setInt(1, worker.getWorkerId());
			preparedStatement.setString(2, worker.getFirstName());
			preparedStatement.setString(3, worker.getLastName());
			preparedStatement.setInt(4, worker.getSalary());
			preparedStatement.setTimestamp(5, worker.getJoiningDate());
			preparedStatement.setString(6, worker.getDepartment());
			preparedStatement.setInt(7, worker.getWorkerId());
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Integer updateSalaryByDepartment(String department, Integer bonusFactor) throws SQLException {
		return 0;
	}

	@Override
	public Integer deleteWorkerById(Integer id) throws SQLException {
        String deleteWorkerFormat = """
                DELETE FROM Worker
                WHERE
                    WORKER_ID = ?""";

		try (PreparedStatement preparedStatement = connection.prepareStatement(deleteWorkerFormat);) {
			preparedStatement.setInt(1, 10);
			return preparedStatement.executeUpdate();
		}
	}
}
