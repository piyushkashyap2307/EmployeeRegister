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


	@RequestMapping("/signOut")
	public ModelAndView signOut(HttpSession session) {
		
		for(User user : this.userService.findAllUsers()) {
			user.setSignedIn(false);
			session.setAttribute("isSignedIn", user.isSignedIn());
		}
		return new ModelAndView("forward:/index");
	}
}
