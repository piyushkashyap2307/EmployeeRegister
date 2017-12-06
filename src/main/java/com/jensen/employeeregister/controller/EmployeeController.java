package main.java.com.jensen.employeeregister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	
	
	

}