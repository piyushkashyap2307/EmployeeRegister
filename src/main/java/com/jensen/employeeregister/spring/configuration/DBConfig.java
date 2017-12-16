package main.java.com.jensen.employeeregister.spring.configuration;


import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DBConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public HibernateTemplate getHibernateTemplate() {
		
		return new HibernateTemplate(this.getSessionFactory());
	}

	@Bean
	public SessionFactory getSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(this.getDataSource());
		localSessionFactoryBean.setPackagesToScan("main.java.com.jensen.employeeregister.model");
		localSessionFactoryBean.setHibernateProperties(this.getHibernateProperties());
		try {
			localSessionFactoryBean.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return localSessionFactoryBean.getObject();
	}
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(this.environment.getProperty("database.driver"));
		datasource.setUrl(this.environment.getProperty("database.url"));
		datasource.setUsername(this.environment.getProperty("database.root"));
		datasource.setPassword(this.environment.getProperty("database.password"));
		
		return datasource;
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager() {
		
		return new HibernateTransactionManager(this.getSessionFactory());
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", this.environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", this.environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", this.environment.getProperty("hibernate.show_sql"));
		return properties;
	}
}
