package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.dto.Credential;
import com.spring.mvc.model.User;
import com.spring.mvc.service.UserService;

@Controller
//@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@RequestMapping("/")
	public String showRegistrationPage(Model model) {
		System.out.println("home");
		return "registration";
	}
	
	@PostMapping("/registration")//@ModelAttribute received object from de view, model is use to send data to view
	public String doRegistration(@ModelAttribute User user, Model model){
		System.out.println("before save user:" + user);
		userService.saveUser(user);
		Credential credential = new Credential();
		model.addAttribute("credential", credential);
      
		return "login";
		
	}
	
	@PostMapping("/login")
	public String authenticateUser(@ModelAttribute Credential credential) {
	User user =	userService.authenticateUser(credential.getName(), credential.getPassword());
	if(ObjectUtils.isEmpty(user)) {
		return "loginFailure";
		
	}
	
	
	return "redirect:/getProducts";
	}
	
/*	@RequestMapping("/logout")
	public String logOut(Model model,HttpServletRequest request) {
		System.out.println("I will close sesion");
		HttpSession sesion = request.getSession();
		sesion.removeAttribute("usuario");
		return "login";
	}*/

}
