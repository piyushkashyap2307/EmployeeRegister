package main.java.com.jensen.employeeregister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import main.java.com.jensen.employeeregister.model.bean.User;
import main.java.com.jensen.employeeregister.model.repository.IUserRepository;

@Controller
public class SignInController {

	@Autowired
	private IUserRepository userRepository;



	@RequestMapping("/admin")
	public ModelAndView signIn(@Valid @ModelAttribute User newUser ,BindingResult bindingResult,
			HttpServletRequest request) {

		for(User user : this.userRepository.getAllUsers()) {
			if (bindingResult.hasErrors()) {
				
				System.out.println("error "+ bindingResult.getErrorCount());
			} 

			if(newUser.getUsername().equals(user.getUsername()) &&
					newUser.getPassword().equals(user.getPassword())) {

				HttpSession session = request.getSession(true);

				user.setSignedIn(true);
				session.setAttribute("isSignedIn", user.isSignedIn());
			}
		}
		return new ModelAndView("forward:/index");
	}


	@RequestMapping("/signOut")
	public ModelAndView signOut(HttpSession session) {
		for(User user : this.userRepository.getAllUsers()) {
			user.setSignedIn(false);
			session.setAttribute("isSignedIn", user.isSignedIn());
			System.out.println("is not signed in");
		}
		return new ModelAndView("forward:/index");
	}
}
