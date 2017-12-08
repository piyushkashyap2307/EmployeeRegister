package main.java.com.jensen.employeeregister.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import main.java.com.jensen.employeeregister.model.bean.Employee;
import main.java.com.jensen.employeeregister.model.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(value = {"/", "index"})
	public ModelAndView employee() {

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("employees",employeeService.getAllEmployees());
		return modelAndView;
	}

	@RequestMapping(value = "/getEmployee")
	public String getEmployee(ModelMap modelMap, HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));
		modelMap.addAttribute("employees",employeeService.getEmployeeById(id));

		return "index";
	}
	@RequestMapping(value = "/edit/{id}")
	public String editEmployee(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", this.employeeService.getEmployeeById(id));
		//		model.addAttribute("employees", this.employeeService.getAllEmployees());
		return "edit";
	}
	
	@RequestMapping(value= "/addEmployee")
	public String addEmployee(HttpServletRequest request) {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String location = request.getParameter("location");
		String role = request.getParameter("role");

		Employee employee = new Employee(firstname, lastname, location, role);

		this.employeeService.addEmployee(employee);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value= "/add")
	public String add() {
		
		return "add";	
	}
	
	@RequestMapping(value = "/edit/updateEmployee")
	public String updateEmployee(HttpServletRequest request) throws ParseException {
		
		String id = request.getParameter("id");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String location = request.getParameter("location");
		String role = request.getParameter("role");

		String date = request.getParameter("registration_date");
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-mm-dd");

		Date newdate = simpleDate.parse(date);
		Employee employee = new Employee(Integer.parseInt(id),firstname, lastname, location, role, newdate);

		this.employeeService.updateEmployee(employee);
		
		return "redirect:/index";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		this.employeeService.deleteEmployee(id);

		return "index";
	}


}