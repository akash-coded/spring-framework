package demo.jpa.boot.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingJpaDataWithRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingJpaDataWithRestApplication.class, args);
		
		System.out.println(
				"Our demo app create and retrieve Person objects stored in a database by using Spring Data REST works!");
	}

}
