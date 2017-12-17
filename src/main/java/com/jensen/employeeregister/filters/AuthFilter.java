package main.java.com.jensen.employeeregister.filters;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This Filter has a sole purpose of validating whether or not the add/edit employee function in the View contains
 * only alphabetical characters. 
 * 	- If true it will grant the client access to the EmployeeController.class mapping.
 * 	- If false it will forward the client back to the main View together with the corresponding
 * 	  error messages.
 * 
 * @author Gustav Malm
 * @author Kami Hassanzadeh
 */
@WebFilter("/employee/add")
public class AuthFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
	
	@Override
	public void destroy() {}
	/**
	 *  This Filter has a sole purpose of validating whether or not the add/edit employee function in the View contains
	 * only alphabetical characters. 
	 * 	- If true it will grant the client access to the EmployeeController.class mapping.
	 * 	- If false it will forward the client back to the main View together with the corresponding
	 * 	  error messages.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;

		String firstname = servletRequest.getParameter("firstname");
		String lastname = servletRequest.getParameter("lastname");
		String location = servletRequest.getParameter("location");
		String role = servletRequest.getParameter("role");
		
		if(this.inputMatches(firstname) && this.inputMatches(lastname) && this.inputMatches(location) && this.inputMatches(role)) {
			
			filterChain.doFilter(request, response);
		}
		else {
			RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/index?error=Only%20characters%20allowed!");

			servletResponse.setContentType("text/html");
			requestDispatcher.forward(servletRequest, servletResponse);
		}

	}
	/**
	 * Checks wheter or not the input String passes through as a "alphabetical only" type of string or not.
	 * 
	 * @param input
	 * @return true or false
	 */
	public boolean inputMatches(String input) {
		Pattern pattern = Pattern.compile("[A-Za-z]");
		Matcher matcher = pattern.matcher(input);
		if(matcher.find()) {
			return true;
		}
		else return false;
	}
}
