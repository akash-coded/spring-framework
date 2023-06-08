package demo.jdbc.boot.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcMysqlConnectorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcMysqlConnectorDemoApplication.class, args);
		
		System.out.println("Our plain JDBC Spring Boot demo app with MySQL connector works!");
	}

}
