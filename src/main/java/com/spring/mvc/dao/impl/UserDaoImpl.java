package com.spring.mvc.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.UserDao;
import com.spring.mvc.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	
	Map<String,User> userDatabase = new HashMap<>();
	@Override
	public void saveUser(User user) {

		
		System.out.println(user.getName()+ "detail saved");
		
		// sesion
		SessionFactory sFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();


		Session session = sFactory.openSession();
		try {

			//User user = new User(1,"jkl2", "morales", "dolores","123");

			// EJECUTAR TRANSACCION
			session.beginTransaction();
			//System.out.println("guardando transaccion,value id:" + user.getUserId());
			// guardando objetos en base de datos
			session.save(user);

			// haciendo comit exitoso
			System.out.println("commit si se ejecuta todo salio bien datos del cliente despues de session.save:" + user);

			session.getTransaction().commit();
			System.out.println();
			

			session.close();
			sFactory.close();
		} catch (Exception e) {
			System.out.println("se genero un error");
			e.printStackTrace();
		}
	}
	@Override
	public User authenticateUser(String name, String password) {

		SessionFactory sFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();


		Session session = sFactory.openSession();
		try {
			session.beginTransaction();
			
			String hql = "FROM User E WHERE E.name = :n";
			System.out.println("este es el query: " + hql);

			Query query = session.createQuery(hql);  
			query.setParameter("n", name);
			
			
			List<User> results = query.getResultList();
			
			System.out.println("tamaño: " + results.get(0));
			
			if(results.get(0).getPassword().equals(password)) {
				return results.get(0);
			}
			
			
			session.close();
			sFactory.close();
		} catch (Exception e) {
			System.out.println("se genero un error");
			e.printStackTrace();
		}
			return null;
		}

}
