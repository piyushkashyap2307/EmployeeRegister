package main.java.com.jensen.employeeregister.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** 
 * This is a utility Class with the sole purpose of generating an encrypted String-value.
 */
public class QuickPasswordEncodingGenerator {
	/** 
	 * This Method is using BCryptPasswordEncoder from Spring Framework Security (Spring Security)
	 * to generate a encrypted password based of the selected String value of String "password". 
	 * 
	 * It then prints out the result into the console for the User to grab for whatever reason it may be.
	 * */
	public static void main(String[] args) {
		String password = "1234";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode(password));
	}

}
