package main.java.com.jensen.employeeregister.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/admin")
public class AuthFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("Filter Started...");
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		
		HttpSession session = servletRequest.getSession();
		
		String username = servletRequest.getParameter("username");
		String password = servletRequest.getParameter("password");
		System.out.println(username.length());
		if(!username.isEmpty() || !password.isEmpty()) {
			filterChain.doFilter(request, response);
		}
		else {
			servletResponse.setContentType("text/html");
			servletResponse.sendRedirect("index.html?error=Username%20or%20password%20is%20not%20be%20empty!");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
