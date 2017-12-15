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

@WebFilter("/employee/add")
public class AuthFilter implements Filter {

	@Override
	public void destroy() {
	}

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
	public boolean inputMatches(String regex) {
		Pattern pattern = Pattern.compile("[A-Za-z]");
		Matcher matcher = pattern.matcher(regex);
		if(matcher.find()) {
			return true;
		}
		else return false;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
