package com.spring.mysql.connector.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection connection = null;
	
	DatabaseConnection(String url, String username, String password) throws SQLException {
		super();
		this.connection = DriverManager.getConnection(url, username, password);
	}
	
	private void printConnectionDetails() throws SQLException {
		System.out.println("Connected to database server "
                + this.connection.getMetaData().getDatabaseProductName()
                + " version: "
                + this.connection.getMetaData().getDatabaseProductVersion()
				+ "\n");
	}

	public Connection getConnection() {
		return connection;
	}
}
