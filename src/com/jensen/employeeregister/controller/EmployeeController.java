package com.jensen.employeeregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jensen.employeeregister.model.bean.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private Employee employee;

	@RequestMapping(value = "/employees")
	public ModelAndView getEmployees(ModelAndView modelAndView) {
		
		
		modelAndView.addObject("employees",employee);
	
		modelAndView.setViewName("employees");
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/New")
	public ModelAndView getNewEmployees(ModelAndView modelAndView) {
		
		
		modelAndView.setViewName("New");
		return modelAndView;
		
	}
}
