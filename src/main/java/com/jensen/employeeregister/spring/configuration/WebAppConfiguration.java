package main.java.com.jensen.employeeregister.spring.configuration;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Configures Thymeleaf, MessageSource, ResourceHandlers.
 * 
 * @author concretepage.com
 * @author Gustav Malm
 * @author Kami Hassanzadeh
 */
@Configuration
@EnableWebMvc
@Import(DBConfig.class)
@ComponentScan("main.java.com.jensen.employeeregister")
public class WebAppConfiguration extends WebMvcConfigurerAdapter {
	/**
	 * It resolves templates with provided prefix and suffix and other settings
	 * 
	 * @return ServletContextTemplateResolver
	 */
	@Bean(name = "templateResolver")
	public ServletContextTemplateResolver initTemplateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/view/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");

		return templateResolver;
	}
	/**
	 * It processes templates. 
	 * We need to assign ServletContextTemplateResolver instance to it. 
	 * @Bean name must be templateEngine. 
	 * 
	 * @return SpringTemplateEngine
	 */
	@Bean(name = "templateEngine")
	public SpringTemplateEngine initTemplateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(this.initTemplateResolver());

		return templateEngine;
	}
	/**
	 * It runs after controller ends its execution. It receives the view name to be processed
	 * 
	 * @return a ThymeleafViewResolver
	 */
	@Bean(name = "viewResolver")
	public ThymeleafViewResolver initViewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(this.initTemplateEngine());

		return viewResolver;
	}
	/**
	 * Makes sure that the ViewController is pointing at the Mapping "/" (root) and then set the view to "index" (index.html)
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");;
	}
	/**
	 * Maps this project's resource folder with the Configuration.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/app-resources/**").addResourceLocations("/resources/");
	}
	/*
	 * Configure MessageSource to provide internationalized messages
	 *
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}