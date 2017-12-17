package main.java.com.jensen.employeeregister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import main.java.com.jensen.employeeregister.model.bean.User;
import main.java.com.jensen.employeeregister.model.service.IUserService;

/**
 * The Sign In Controller that controls whether or not the User is successfully Signed in or not.
 *
 * @author Gustav Malm
 * @author Kami Hassanzadeh
 */
@Controller
public class SignInController {
	/**
	 * Autowired the IUserService.class in order to call methods from it.
	 */
	@Autowired
	private IUserService userService;
	/**
	 * Autowired the PasswordEncoder @Bean to be able to encrypt/encode the password if needed.
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;
	/**
	 * A Sign In mapping that validates the Sign In depending on if the Username and password matched with any
	 * User instance. If it passes then we set the "isSignedIn" boolean to true
	 * 
	 * @param user - A temporary User object based on the Sign In input from the View.
	 * @return View "index" with or without an error message depending on the Sign In result.
	 */
	@RequestMapping("/admin")
	public ModelAndView signIn(@Valid @ModelAttribute User user, HttpServletRequest request) {

		for(User object : this.userService.findAllUsers()) {

			if(user.getUsername().equals(object.getUsername())) {
				User entity = this.userService.findByUsername(user.getUsername());
				
				if(!user.getPassword().isEmpty() && !entity.getPassword().isEmpty() && this.passwordEncoder.matches(user.getPassword(), entity.getPassword())) {
					HttpSession session = request.getSession(true);

					object.setSignedIn(true);
					session.setAttribute("isSignedIn", object.isSignedIn());
				}
			}
			else {
				return new ModelAndView("forward:/index?error=Invalid%20Credentials%20provided!");
			}
		}
		return new ModelAndView("forward:/index");
	}
	/**
	 * Signs Out the User and sets the "isSignedIn" boolean to false;
	 * @return
	 */
	@RequestMapping("/signOut")
	public ModelAndView signOut(HttpSession session) {
		
		for(User user : this.userService.findAllUsers()) {
			user.setSignedIn(false);
			session.setAttribute("isSignedIn", user.isSignedIn());
		}
		return new ModelAndView("forward:/index");
	}
}