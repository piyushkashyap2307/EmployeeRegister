package main.java.com.jensen.employeeregister.model.service;

import java.util.List;

import main.java.com.jensen.employeeregister.model.bean.Employee;

public interface IEmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(int id);
	
	void updateEmployee (Employee employee);
	
	void deleteEmployee(int id);
	
	void addEmployee(Employee employee);

}
