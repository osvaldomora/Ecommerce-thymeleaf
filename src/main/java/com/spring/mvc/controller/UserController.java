package com.spring.mvc.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.dto.Credential;
import com.spring.mvc.model.Order;
import com.spring.mvc.model.Product;
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
		//methodTest();
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
	
	
	@ResponseBody
	@PostMapping(value ="/registrationRest")
	public ResponseEntity<Object> doRegistrationRest(@RequestBody User user){
		System.out.println("In method");
		userService.saveUser(user);
		Credential credential = new Credential();
 
		 return new ResponseEntity<>(user,  HttpStatus.ACCEPTED);
		
	}
	
	@ResponseBody
	@GetMapping("/registrationRest")
	public String doRegistrationRest2(){
		System.out.println("In method");

 
		 return "today will be thw best dah";
		
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
	
	private void methodTest() {
		

		// crear sessionFactory:lee archivos de configuracion, crea objetos de tipo
		// sesion
		
		System.out.println("ASSD a asdasd TO ssdd");
		SessionFactory sFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Order.class).addAnnotatedClass(Product.class)
				.buildSessionFactory();

		// crearSession:conecta con la base de datos y guardaa y muestra los objetos del
		// mapeo
		Session session = sFactory.openSession();
		List<Order> results = null;
		try {
			
			
			String hql = "FROM Order";
			System.out.println("este es el query: " + hql);	
		
			Query query = session.createQuery(hql);  
			results = query.getResultList();
			
			results.stream().forEach(x->System.out.println(x));
			/*Product product = new Product(6,"White patito", "phone001", 400, 18, "no-image.png", true);
			Product product2 = new Product(7,"White patito", "phone002", 400, 18, "no-image.png", true);
			
			Order order = new Order();
			order.add(product);
			order.add(product2);
			order.setName("as");
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();*/
			
			/*
			// crar objeto Producto
			Product product = new Product(1,"White patito", "phone", 400, 18, "no-image.png", true);

			// EJECUTAR TRANSACCION
			System.out.println("comenzando transaccion");
			// comenzando Transaccion
			session.beginTransaction();
			// guardando objetos en base de datos
			session.save(product);

			// haciendo comit exitoso
			System.out.println(
					"commit si se ejecuta todo salio bien datos del cliente despues de session.save:" + product);
			session.getTransaction().commit();
			System.out.println();
			*/
			session.close();
			sFactory.close();
		} catch (Exception e) {
			System.out.println("se genero un error");
			e.printStackTrace();
		}
	
		
	}

}
