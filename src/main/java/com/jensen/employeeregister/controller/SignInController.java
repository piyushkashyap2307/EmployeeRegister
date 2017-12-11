package main.java.com.jensen.employeeregister.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import main.java.com.jensen.employeeregister.model.bean.User;

@Controller
public class SignInController {

	private User user = new User();

	@RequestMapping("/admin")
	public ModelAndView signIn(@ModelAttribute User newUser , HttpServletRequest request) {

		this.user.setUserName("");
		this.user.setPassword("");


		if(newUser.getUserName().equals(this.user.getUserName()) &&
				newUser.getPassword().equals(this.user.getPassword())) {
			HttpSession session = request.getSession(true);
			
			this.user.setSignedIn(true);
			session.setAttribute("isSignedIn", this.user.isSignedIn());
			
//			model.addAttribute("signedIn", this.user.isSignedIn());
			System.out.println("is inloggad");
			System.out.println("sträng" + session.getAttribute("isSignedIn"));
		}
		return new ModelAndView("forward:/index");
	}
	@RequestMapping("/signOut")
	public ModelAndView signOut(HttpSession session) {

		this.user.setSignedIn(false);
		session.setAttribute("isSignedIn", this.user.isSignedIn());
		System.out.println("is not signed in");
		System.out.println("sträng" + session.getAttribute("isSignedIn"));

		return new ModelAndView("forward:/index");
	}
}
