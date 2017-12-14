package main.java.com.jensen.employeeregister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import main.java.com.jensen.employeeregister.model.bean.User;
import main.java.com.jensen.employeeregister.model.service.IUserService;

@Controller
public class SignInController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping("/admin")
	public ModelAndView signIn(@Valid @ModelAttribute User newUser, BindingResult bindingResult,
			HttpServletRequest request) {

		for(User user : this.userService.findAllUsers()) {
			if (bindingResult.hasErrors()) {
				return new ModelAndView("forward:/index?error=Invalid%20Credentials%20provided!");
			} 
			
			if(newUser.getUsername().equals(user.getUsername())) {
				User entity = this.userService.findByUsername(newUser.getUsername());
				System.out.println("This user taken from db: " + entity);
				if(!newUser.getPassword().isEmpty() && !entity.getPassword().isEmpty() && this.passwordEncoder.matches(newUser.getPassword(), entity.getPassword())) {
					HttpSession session = request.getSession(true);

					user.setSignedIn(true);
					session.setAttribute("isSignedIn", user.isSignedIn());
				}
				
			}
		}
		return new ModelAndView("forward:/index");
	}


	@RequestMapping("/signOut")
	public ModelAndView signOut(HttpSession session) {
		for(User user : this.userService.findAllUsers()) {
			user.setSignedIn(false);
			session.setAttribute("isSignedIn", user.isSignedIn());
		}
		return new ModelAndView("forward:/index");
	}
}
