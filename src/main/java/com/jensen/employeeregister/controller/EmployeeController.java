package main.java.com.jensen.employeeregister.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import main.java.com.jensen.employeeregister.model.bean.Employee;
import main.java.com.jensen.employeeregister.model.bean.User;
import main.java.com.jensen.employeeregister.model.service.IEmployeeService;

/**
 * The Employee Controller that controls the Employee Management.
 *
 * @author Gustav Malm
 * @author Kami Hassanzadeh
 */
@Controller
public class EmployeeController {
	/**
	 * Autowired the IEmployeeService.class in order to call methods from it.
	 */
	@Autowired
	private IEmployeeService employeeService;
	/**
	 * Updates the view with the complete list of Employees.
	 */
	@RequestMapping(value = {"/", "index"})
	public String employee(Model model, @ModelAttribute User user) {
		model.addAttribute("employees", this.employeeService.getAllEmployees());

		return "index";
	}
	/** 
	 * Create new Employee (or if the employee already exists updates that Object reference)
	 */
	@PostMapping(value= "/employee/add")
	public String addEmployee(@ModelAttribute Employee employee, Model model) {
		
		if(employee.getId() == 0) {
			this.employeeService.addEmployee(employee);
			model.addAttribute("employee", new Employee());
		} else {
			employee.setRegistrationDate(this.employeeService.getEmployeeById(employee.getId()).getRegistrationDate());
			this.employeeService.updateEmployee(employee);
			model.addAttribute("employees", this.employeeService.getAllEmployees());
		}
		return "redirect:/index";
	}
	/** 
	 * Get/Find a specific Employee Object with the help of a input value representing an Employee.id.
	 */
	@GetMapping(value = "getEmployee")
	public String getEmployee(Model model, HttpServletRequest request) {
		String searchValue = request.getParameter("searchValue");
		model.addAttribute("employees", this.employeeService.getEmployeesFromSearch(searchValue));

		return "index";
	}
	/** 
	* Edit a specific Employee Object with the help of a input value representing an Employee.id.
	*/
	@GetMapping(value = "/edit/{id}")
	public String editEmployee(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", this.employeeService.getEmployeeById(id));
		model.addAttribute("employees", this.employeeService.getAllEmployees());

		return "index";
	}
	/** 
	 * Delete a specific Employee Object with the help of a input value representing an Employee.id.
	 */
	@RequestMapping(value = "/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id, Model model) {
		this.employeeService.deleteEmployee(id);
		model.addAttribute("employees", this.employeeService.getAllEmployees());

		return "redirect:/index";
	}
}