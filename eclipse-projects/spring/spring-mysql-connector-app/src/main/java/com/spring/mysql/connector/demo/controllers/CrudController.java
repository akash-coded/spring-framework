package com.spring.mysql.connector.demo.controllers;

import java.sql.*;

import com.spring.mysql.connector.demo.util.DatabaseConnection;

public class CrudController {
	private final Connection connection;

	public CrudController(DatabaseConnection connection) {
		super();
		this.connection = connection.getConnection();
	}
	
	public void read() {
        // Read (Retrieve) Operation using PreparedStatement
        String selectFormat = """
                SELECT *
                FROM
                    Worker
                WHERE
                    WORKER_ID > ?""";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectFormat)) {
            preparedStatement.setInt(1, 3);
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.isBeforeFirst()) {
                System.out.println("no rows found");
            } else {
                int columnCount = rs.getMetaData().getColumnCount();
                System.out.println("Columns and Types::");
                for (int i = 0; i < columnCount; i++) {
                    System.out.print(rs.getMetaData().getColumnName(i + 1) + ":"
                            + rs.getMetaData().getColumnTypeName(i + 1) + "\t");
                }
                System.out.println("\nRecords::");
                while (rs.next()) {
                    for (int i = 1; i < columnCount + 1; i++) {
                        System.out.print(rs.getObject(i) + "\t");
                    }
                    System.out.println();
                }
            }
        } catch (SQLException e) {
        	System.out.println("Exception occurred in read() method of CrudController\n" + e);
        }
	}

}
