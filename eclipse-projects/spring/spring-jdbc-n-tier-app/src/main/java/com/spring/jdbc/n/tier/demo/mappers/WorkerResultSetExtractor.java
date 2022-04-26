package com.spring.jdbc.n.tier.demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.spring.jdbc.n.tier.demo.models.Worker;

public class WorkerResultSetExtractor implements ResultSetExtractor<Worker> {

	@Override
	public Worker extractData(ResultSet rs) throws SQLException {
		Worker worker = new Worker();

		worker.setWorkerId(rs.getInt("WORKER_ID"));
		worker.setFirstName(rs.getString("FIRST_NAME"));
		worker.setLastName(rs.getString("LAST_NAME"));
		worker.setSalary(rs.getInt("SALARY"));
		worker.setJoiningDate(rs.getTimestamp("JOINING_DATE"));
		worker.setDepartment(rs.getString("DEPARTMENT"));

		return worker;
	}

}
