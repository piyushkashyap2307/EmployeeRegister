package main.java.com.jensen.employeeregister.controller;

import org.apache.openejb.server.httpd.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import main.java.com.jensen.employeeregister.model.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(value = "/all-employees")
	public ModelAndView getEmployees(ModelAndView modelAndView) {
		
		modelAndView.addObject("employees",employeeService.getAllEmployees());
	
		modelAndView.setViewName("employees");
		return modelAndView;
	}
	
	
//	@RequestMapping(value = "one-employee")
//	public String getoneEmployees(ModelMap modelMap, HttpRequest request) {
//		
//		int id = Integer.parseInt(request.getParameter("getEmployeeById"));
//		
//		modelMap.addObject("employees",employeeService.getEmployeeById(id));
//	
//		modelMap.setViewName("employees");
//		return modelMap;
//		
//	}
}
