package main.java.com.jensen.employeeregister.model.repository;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import main.java.com.jensen.employeeregister.model.bean.Employee;

@Transactional
@Repository
public class EmployeeRepository implements IEmployeeRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	/**
	 * Method for obtaining a list of all Employees with the assistance of the HibernateTemplate.
	 * 
	 * @return a list of all Employees
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		String query = "FROM employees";
		
		return (List<Employee>) this.hibernateTemplate.find(query);
	}
	/**
	 * Method for obtaining a Employee based on the id value passed through as a parameter.
	 * 
	 * @return a Employee with the specific id value
	 */
	@Override
	public Employee getEmployeeById(int id) {

		return hibernateTemplate.get(Employee.class, id);
	}
	/**
	 * Method for obtaining a list of Employees based on the result from the "searchResult".
	 * 
	 * @return a list of Employees that passed through the "searchResult"
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeesFromSearch(String searchResult) {
		String query = "FROM employees WHERE "
				+ "employee_id LIKE '%"+searchResult+"%' "
				+ "OR fname LIKE '%"+searchResult+"%' "
				+ "OR lname LIKE '%"+searchResult+"%' "
				+ "OR location LIKE '%"+searchResult+"%' "
				+ "OR role LIKE '%"+searchResult+"%'";

		return (List<Employee>) this.hibernateTemplate.find(query);
	}
	/**
	 * Method for adding a Employee based on the Employee Object passing through as a parameter.
	 * 
	 */
	@Override
	public void addEmployee(Employee employee) {
		this.hibernateTemplate.save(employee);
	}
	/**
	 * Method for updating a Employee based on the data from a Employee Object passing through as a parameter.
	 * 
	 */
	@Override
	public void updateEmployee(Employee employee) {
		Employee entity = this.getEmployeeById(employee.getId());

		entity.setFirstname(employee.getFirstname());
		entity.setLastname(employee.getLastname());
		entity.setLocation(employee.getLocation());
		entity.setRole(employee.getRole());
		entity.setRegistrationDate(employee.getRegistrationDate());

		this.hibernateTemplate.update(entity);
	}
	/**
	 * Method for removing a Employee based on the id value passing through as a parameter.
	 * 
	 */
	@Override
	public void deleteEmployee(int id) {
		this.hibernateTemplate.delete(this.getEmployeeById(id));
	}
}
