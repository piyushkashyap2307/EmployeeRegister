package com.jensen.employeeregister.spring.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DBConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		
		return new HibernateTemplate(this.sessionFactory());
	}

	@Bean
	private SessionFactory sessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(this.getDataSource());
		localSessionFactoryBean.setPackagesToScan("com.jensen.employeeregister.model");
		localSessionFactoryBean.setHibernateProperties(this.hibernateProperties());
		return null;
	}
	
	private Properties hibernateProperties() {
		
		return null;
	}

	private DataSource getDataSource() {
		
		return null;
	}

}
