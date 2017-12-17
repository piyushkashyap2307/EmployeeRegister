package main.java.com.jensen.employeeregister.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.jensen.employeeregister.model.bean.Employee;
import main.java.com.jensen.employeeregister.model.repository.IEmployeeRepository;

/**
 * A Service Layered Class which is interacting with the IEmployeeRepository.class.
 * This Class deals with the more business-like code and forwards it to the IEmployeeRepository.class
 * once passed.
 * 
 * @author Gustav Malm
 * @author Kami Hassanzadeh
 */
@Service
public class EmployeeService implements IEmployeeService {
	/**
	 * Autowired the IEmployeeRepository.class in order to call methods from it.
	 */
	@Autowired
	private IEmployeeRepository employeeRepository;
	/**
	 * Method for obtaining a list of all Employees with the assistance IEmployeeRepository.class.
	 * 
	 * @return a list of all Employees
	 */
	@Override
	public List<Employee> getAllEmployees() {
		
		return this.employeeRepository.getAllEmployees();
	}
	/**
	 * Method for obtaining single Employee with the assistance IEmployeeRepository.class.
	 * 
	 * @return a Employee
	 */
	@Override
	public Employee getEmployeeById(int id) {
		
		Employee employee = this.employeeRepository.getEmployeeById(id);
		
		return employee;
	}
	/**
	 * Method for obtaining a list Employees with the assistance IEmployeeRepository.class.
	 * 
	 * @return a list of all Employees which meets the Search criteria.
	 */
	@Override
	public List<Employee> getEmployeesFromSearch(String searchResult) {
		
		return this.employeeRepository.getEmployeesFromSearch(searchResult);
	}
	/**
	 * Method for updating a single Employee with the assistance IEmployeeRepository.class.
	 * 
	 */
	@Override
	public void updateEmployee(Employee employee) {
		this.employeeRepository.updateEmployee(employee);
	}
	/**
	 * Method for removing a single Employee with the assistance IEmployeeRepository.class.
	 * 
	 */
	@Override
	public void deleteEmployee(int id) {
		this.employeeRepository.deleteEmployee(id);
	}
	/**
	 * Method for adding a new Employee with the assistance IEmployeeRepository.class.
	 * 
	 */
	@Override
	public void addEmployee(Employee employee) {
		this.employeeRepository.addEmployee(employee);
	}
}