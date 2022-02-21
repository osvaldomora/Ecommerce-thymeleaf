package com.spring.mvc.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dao.ProductDao;
import com.spring.mvc.model.Product;
import com.spring.mvc.model.User;


@Repository
public class ProductDaoImpl implements ProductDao{

	List<Product> productsList = new ArrayList();

	
	@Override
	public List<Product> getProductsHibernate(){
		SessionFactory sFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Product.class)
				.buildSessionFactory();


		Session session = sFactory.openSession();
		List<Product> results = null;
		try {
			session.beginTransaction();
			
			String hql = "FROM Product";
			System.out.println("este es el query: " + hql);	
			//Query query = session.createQuery(hql);
		
			Query query = session.createQuery(hql);  
			//query.setParameter("n", name);
			//List list=query.list();
			
			results = query.getResultList();
			
			//System.out.println("tamaño: " + results.get(0));
			
			
			
			session.close();
			sFactory.close();
			return results;
		} catch (Exception e) {
			System.out.println("se genero un error");
			e.printStackTrace();
		}
		
		return results;
		//return productsList;

		
	}
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		Product product1 = new  Product();
		product1.setProductId(1);
		product1.setProductName("Samgung");
		product1.setProductCategory("phone");
		product1.setProductPrice(1000L);
		product1.setProductQuantity(10L);
		
		Product product2 = new  Product();
		product2.setProductId(2);
		product2.setProductName("Patito");
		product2.setProductCategory("phone");
		product2.setProductPrice(300L);
		product2.setProductQuantity(8L);
		
		Product product3 = new  Product();
		product3.setProductId(3);
		product3.setProductName("Apple");
		product3.setProductCategory("phone");
		product3.setProductPrice(300L);
		product3.setProductQuantity(8L);
		
		Product product4 = new  Product();
		product4.setProductId(4);
		product4.setProductName("Sony");
		product4.setProductCategory("phone");
		product4.setProductPrice(200L);
		product4.setProductQuantity(18L);
		
		Product product5 = new  Product();
		product5.setProductId(5);
		product5.setProductName("White Patito ");
		product5.setProductCategory("phone");
		product5.setProductPrice(200L);
		product5.setProductQuantity(18L);
		
		List<Product> productList = Arrays.asList(product1,product2,product3,product4,product5);
		return productList;
	}

}
