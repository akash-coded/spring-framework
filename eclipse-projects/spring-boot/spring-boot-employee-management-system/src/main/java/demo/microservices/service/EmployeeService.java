package demo.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.microservices.model.Employee;
import demo.microservices.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Long id, Employee newEmployee) {
		return employeeRepository.findById(id)
				.map(employee -> {
					employee.setName(newEmployee.getName());
					employee.setDepartment(newEmployee.getDepartment());
					return employeeRepository.save(employee);
				})
				.orElseGet(() -> {
					newEmployee.setId(id);
					return employeeRepository.save(newEmployee);
				});
	}
	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
}
