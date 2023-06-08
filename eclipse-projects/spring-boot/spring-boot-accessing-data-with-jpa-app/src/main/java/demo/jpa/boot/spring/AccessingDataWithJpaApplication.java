package demo.jpa.boot.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import demo.jpa.boot.spring.entities.Customer;
import demo.jpa.boot.spring.repositories.CustomerRepository;

/**
 * @author Akash
 * 
 * @SpringBootApplication is a convenience annotation that adds all of the
 *                        following:
 * 
 *                        - @Configuration: Tags the class as a source of bean
 *                        definitions for the application context.
 *                        
 *                        - @EnableAutoConfiguration: Tells Spring Boot to start
 *                        adding beans based on classpath settings, other beans,
 *                        and various property settings. For example, if
 *                        spring-webmvc is on the classpath, this annotation
 *                        flags the application as a web application and
 *                        activates key behaviors, such as setting up a
 *                        DispatcherServlet. 
 *                        
 *                        - @ComponentScan: Tells Spring to
 *                        look for other components, configurations, and
 *                        services in the base package, letting it find the
 *                        controllers.
 * 
 * The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
 * 
 */
@SpringBootApplication
public class AccessingDataWithJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataWithJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataWithJpaApplication.class, args);

		System.out.println(
				"Our application that stores Customer POJOs (Plain Old Java Objects) in a memory-based database works!");
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}
