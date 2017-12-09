package main.java.com.jensen.employeeregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import main.java.com.jensen.employeeregister.model.bean.Employee;
import main.java.com.jensen.employeeregister.model.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(value = {"/", "index"})
	public String employee(Model model) {
		// model.addAttribute("employee", new Employee());
		model.addAttribute("employees", this.employeeService.getAllEmployees());
		
		return "index";
	}

	@RequestMapping(value = "/employee/{id}")
	public String getEmployee(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", this.employeeService.getEmployeeById(id));
		model.addAttribute("employees", this.employeeService.getAllEmployees());

		return "index";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editEmployee(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", this.employeeService.getEmployeeById(id));
		model.addAttribute("employees", this.employeeService.getAllEmployees());
		
		return "index";
	}
	
	/* 
	 * Create new Employee (or if the employee already exists updates that Object reference)
	 * */
	@PostMapping(value= "/employee/add")
	public String addEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		if(employee.getId() == 0) {
			this.employeeService.addEmployee(employee);
			model.addAttribute("employee", new Employee());
		} else {
			this.employeeService.updateEmployee(employee);
		}
		
		return "redirect:/index";
	}

	/* 
	 * Delete this Employee by an ID-variable
	 * */
	@RequestMapping(value = "/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		this.employeeService.deleteEmployee(id);

		return "index";
	}
}