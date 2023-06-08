package demo.jpa.boot.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import demo.jpa.boot.spring.entities.Customer;

/**
 * @author Akash
 * 
 * CustomerRepository extends the CrudRepository interface.
 * 
 * The type of entity and ID that it works with, Customer and Long, are specified in the generic parameters on CrudRepository.
 * 
 * By extending CrudRepository, CustomerRepository inherits several methods for working with Customer persistence, 
 * including methods for saving, deleting, and finding Customer entities.
 * 
 * Spring Data JPA also lets you define other query methods by declaring their method signature.
 * For example, CustomerRepository includes the findByLastName() method.
 * 
 * In a typical Java application, you might expect to write a class that implements CustomerRepository.
 * 
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

	Customer findById(long id);
}
