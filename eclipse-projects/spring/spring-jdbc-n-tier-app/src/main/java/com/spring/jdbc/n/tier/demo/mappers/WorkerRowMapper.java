package com.spring.jdbc.n.tier.demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.n.tier.demo.models.Worker;

public class WorkerRowMapper implements RowMapper<Worker> {

	@Override
	public Worker mapRow(ResultSet rs, int rowNum) throws SQLException {
		WorkerResultSetExtractor extractor = new WorkerResultSetExtractor();
		return extractor.extractData(rs);
	}
	
}
