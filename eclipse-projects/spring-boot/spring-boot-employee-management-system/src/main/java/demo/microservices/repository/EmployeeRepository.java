package demo.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.microservices.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
