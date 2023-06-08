package demo.microservices.boot.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuotersRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuotersRestfulApplication.class, args);
		
		System.out.println("Our demo quoters RESTful web service works.");
	}

}
