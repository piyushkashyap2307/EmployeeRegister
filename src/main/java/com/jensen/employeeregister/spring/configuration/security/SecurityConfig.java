package main.java.com.jensen.employeeregister.spring.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * This Configuration Class is responsible for all the Security within this Application.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.formLogin()
        		.loginPage("/")
        		.usernameParameter("username")
        		.passwordParameter("password")
            .and()
                .logout()
               	.logoutSuccessUrl("/");
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   
}
