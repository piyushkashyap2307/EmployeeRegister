package main.java.com.jensen.employeeregister.spring.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInit implements WebApplicationInitializer{
	/**
	 * Configures the DispatcherServlet as well as registrating the WebAppConfiguration.class.
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebAppConfiguration.class);
		
		context.setServletContext(servletContext);
		
		Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("/");
	}
}