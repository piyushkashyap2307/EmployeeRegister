package com.jensen.employeeregister.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	private String name;
	private int age;

	@RequestMapping(value = "/employees")
	public ModelAndView getEmployees(ModelAndView modelAndView) {
		
		this.name = "kami";
		this.age = 33;
		
		modelAndView.addObject("employeeName",name);
		modelAndView.addObject("employeeAge",age);
		modelAndView.setViewName("employees");
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/New")
	public ModelAndView getNewEmployees(ModelAndView modelAndView) {
		
		
		modelAndView.setViewName("New");
		return modelAndView;
		
	}
}
