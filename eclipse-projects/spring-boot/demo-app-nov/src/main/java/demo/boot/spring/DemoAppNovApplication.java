package demo.boot.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAppNovApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAppNovApplication.class, args);
		System.out.println("Our first Spring Boot application runs!");
	}

}
