package com.jensen.employeeregister.model.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.jensen.employeeregister.model.bean.Employee;

@Transactional
@Repository
public class EmployeeRepository implements IEmployeeRepository {

	@Override
	public List<Employee> getAllEmployees() {
		
		return null;
	}

	@Override
	public Employee getEmployee(int id) {
		
		return null;
	}

	@Override
	public void saveEmployee(Employee employee) {
	}

	@Override
	public void updateEmployee(Employee employee) {
	}

	@Override
	public void deleteEmployee(int id) {
	}

}
