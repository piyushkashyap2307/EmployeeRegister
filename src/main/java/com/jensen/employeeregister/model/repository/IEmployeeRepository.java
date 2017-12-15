package main.java.com.jensen.employeeregister.model.repository;

import java.util.List;

import main.java.com.jensen.employeeregister.model.bean.Employee;

/**
 * An Interface for the EmployeeRepository.class
 * 
 */
public interface IEmployeeRepository {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(int id);
	
	List<Employee> getEmployeesFromSearch(String searchResult);
	
	void addEmployee (Employee employee);
	
	void updateEmployee (Employee employee);
	
	void deleteEmployee(int id);
	
}
