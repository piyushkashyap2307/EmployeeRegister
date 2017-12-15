package main.java.com.jensen.employeeregister.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.jensen.employeeregister.model.bean.Employee;
import main.java.com.jensen.employeeregister.model.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return this.employeeRepository.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		Employee employee = this.employeeRepository.getEmployeeById(id);
		
		return employee;
	}
	@Override
	public List<Employee> getEmployeesFromSearch(String searchResult) {
		
		return this.employeeRepository.getEmployeesFromSearch(searchResult);
	}

	@Override
	public void updateEmployee(Employee employee) {
		this.employeeRepository.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		this.employeeRepository.deleteEmployee(id);
	}

	@Override
	public void addEmployee(Employee employee) {
		this.employeeRepository.addEmployee(employee);
	}

	

}