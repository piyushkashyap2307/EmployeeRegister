package main.java.com.jensen.employeeregister.model.repository;

import java.util.List;

import main.java.com.jensen.employeeregister.model.bean.Employee;

public interface IEmployeeRepository {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(int id);
	
	void addEmployee (Employee employee);
	
	void updateEmployee (Employee employee);
	
	void deleteEmployee(int id);

}
