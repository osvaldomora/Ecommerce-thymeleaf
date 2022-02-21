package com.spring.mvc.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
	
	@Autowired
	SessionFactory sFactory;
	@RequestMapping("/")
	public String showRegistrationPage(Model model) {
		System.out.println("home");
		methodTest();
		return "registration";
	}
	
	private void methodTest() {
		


		// crear sessionFactory:lee archivos de configuracion, crea objetos de tipo
		// sesion
//		SessionFactory sFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
//				.buildSessionFactory();

		// crearSession:conecta con la base de datos y guardaa y muestra los objetos del
		// mapeo
		Session session = sFactory.openSession();
		try {
			// crar objeto cliente
			User user = new User(1,"jkl2", "morales", "dolores","123");

			// EJECUTAR TRANSACCION
			System.out.println("comenzando transaccion");
			// comenzando Transaccion
			session.beginTransaction();
			System.out.println("guardando transaccion,value id:" + user.getUserId());
			// guardando objetos en base de datos
			session.save(user);

			// haciendo comit exitoso
			System.out.println(
					"commit si se ejecuta todo salio bien datos del cliente despues de session.save:" + user);// estoy
																													// obteniendo
																													// del																											// base
																													// de
																													// datos
			session.getTransaction().commit();
			System.out.println();
			

			session.close();
			sFactory.close();
		} catch (Exception e) {
			System.out.println("se genero un error");
			e.printStackTrace();
		}

	
		
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
