package com.spring.mvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dao.BuyProductDao;
import com.spring.mvc.model.Order;
import com.spring.mvc.model.Product;


@Repository
public class BuyProductDaoImpl implements BuyProductDao{
	


	List<Product> productsList = new ArrayList<Product>();
	
	List<Product> backupBuyProducts = new ArrayList<Product>();
	
    List<List<Product>> registerBuyProducts = new ArrayList<List<Product>>();

	@Override
	public void saveBuyProducts(List<Product> products) {
		for(Product alias: products) { 

			productsList.add(alias);
		}
	}

	@Override
	public List<Product> getBuyProducts() {
		return productsList;
	}
	
	@Override
	public void clearBuyProduct() {
		
		backupBuyProducts=productsList;

		
		//I am going to create a order
		 method(backupBuyProducts); //

		System.out.println("prices was finish to print");


//		addList(backupBuyProducts);
		productsList = new ArrayList<Product>();
		
	}
	
	private void method(List<Product> backupBuyProducts2) {
		

		
		SessionFactory sFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Order.class).addAnnotatedClass(Product.class)
				.buildSessionFactory();

		registerBuyProducts = new ArrayList<List<Product>>();
		
		Session session = sFactory.openSession();
		List<Order> results = null;
		try {
			
			
			System.out.println(" this is the back up");
			backupBuyProducts2.stream().forEach(x->System.out.println(x));
			
			Order order = new Order();
			for(Product alias:backupBuyProducts2) {
				order.add(alias);
			}
		
			order.setName("this is any name");
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
			

			session.close();
			sFactory.close();
		} catch (Exception e) {
			System.out.println("se genero un error");
			e.printStackTrace();
		}
	
		
	
		
	}



	@Override
	public List<Order>  GetBuyProduct() {	

	
		return getBuyProductsHibernate();
		
	}

	private List<Order> getBuyProductsHibernate() {
    

		System.out.println("TYING AGAIN GOIG TO FINISH");
		SessionFactory sFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Order.class).addAnnotatedClass(Product.class)
				.buildSessionFactory();

		Session session = sFactory.openSession();
		List<Order> results = null;
		try {

			session.beginTransaction();
			
			String hql = "FROM Order";
			System.out.println("este es el query: " + hql);	
			
		
			Query query = session.createQuery(hql);  		
			results = query.getResultList();
			System.out.println("WEE new rr RESULTS");
			results.stream().forEach(x->System.out.println(x));
			
			System.out.println("QQQQQQQ values");
			for(Order alias: results) {
				int sum= (int)	alias.getProducts().stream().mapToLong(x -> x.getProductPrice()).sum();
				System.out.println("THE NEW SUM IS :"+sum);
				
					alias.setTotal(sum);
				
				
				System.out.println(alias);
			
			}

			
			
			session.close();
			sFactory.close();
			
		
			
		} catch (Exception e) {
			System.out.println("ERROR WAS GENERATED");
			e.printStackTrace();
		}
	
		
	
		
		return results;
	}



}
