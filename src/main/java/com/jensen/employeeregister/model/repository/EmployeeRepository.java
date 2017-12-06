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

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		String query = "FROM employees";
	
		return (List<Employee>) hibernateTemplate.find(query);
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return hibernateTemplate.get(Employee.class, id);
	}

	@Override
	public void addEmployee(Employee employee) {
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		
		Employee newEmployee = this.getEmployeeById(employee.getId());
		
		newEmployee.setFirstname(employee.getFirstname());
		newEmployee.setLastname(employee.getLastname());
		newEmployee.setLocation(employee.getLocation());
		newEmployee.setRole(employee.getRole());
		newEmployee.setRegistration_date(employee.getRegistration_date());
		
		this.hibernateTemplate.update(newEmployee);
	}

	@Override
	public void deleteEmployee(int id) {
		this.hibernateTemplate.delete(this.getEmployeeById(id));
	}

}
