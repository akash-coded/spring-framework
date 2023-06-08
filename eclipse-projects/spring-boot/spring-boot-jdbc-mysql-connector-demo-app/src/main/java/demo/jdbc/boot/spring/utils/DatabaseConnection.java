/**
 * 
 */
package demo.jdbc.boot.spring.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Akash
 * 
 * Helper class for connecting with the RDB server
 *
 */
@Component
@PropertySource("classpath:application.properties")
public class DatabaseConnection {
	private Connection connection = null;
	
	DatabaseConnection(
			@Value("${db.url}") String url, 
			@Value("${db.username}") String username, 
			@Value("${db.password}") String password
			) throws SQLException {
		this.connection = DriverManager.getConnection(url, username, password);
	}
	
	@SuppressWarnings("unused")
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
