package com.jensen.employeeregister.model.repository;

import java.util.List;

import com.jensen.employeeregister.model.bean.Employee;

public interface IEmployeeRepository {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployee(int id);
	
	void saveEmployee (Employee employee);
	
	void updateEmployee (Employee employee);
	
	void deleteEmployee(int id);

}
