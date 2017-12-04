package com.jensen.employeeregister.spring.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.jensen.employeeregister")
public class WebAppConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean(name = "templateResolver")
	public ServletContextTemplateResolver getTemplateResolver() {
		
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/view/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("XHTML");
		return templateResolver;
	}
	
	@Bean(name = "templateEngine")
	public SpringTemplateEngine getTemplateEngine() {
		
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(this.getTemplateResolver());
		return templateEngine;
	}
	
	@Bean(name = "viewResolver")
	public ThymeleafViewResolver getViewResolver() {
		
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(this.getTemplateEngine());
		return viewResolver;
	}
	@Bean(name = "messageSource")
	public MessageSource getMessageSource() {
		
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/i18/blogmsg");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	

}
