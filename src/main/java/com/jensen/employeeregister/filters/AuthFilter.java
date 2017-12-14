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
		Object isSignedIn = session.getAttribute("isSignedIn");
		System.out.println(isSignedIn);
//		if(isSignedIn != null && (boolean) isSignedIn) {
//			
			filterChain.doFilter(request, response);
//		}
//		else {
//			servletResponse.setContentType("text/html");
//			servletResponse.sendRedirect("index.html?error=Not%20signed%20in!");
//		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
