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
	
	private static int inc=1;

	List<Product> productsList = new ArrayList<Product>();
	
	List<Product> backupBuyProducts = new ArrayList<Product>();
	
    List<List<Product>> registerBuyProducts = new ArrayList<List<Product>>();

	@Override
	public void saveBuyProducts(List<Product> products) {
		for(Product alias: products) { 
//			alias.setOrder(1);
			productsList.add(alias);
		}
	}

	@Override
	public List<Product> getBuyProducts() {
//		productsList.forEach(x->System.out.println(x));
		return productsList;
	}
	
	@Override
	public void clearBuyProduct() {
		
		backupBuyProducts=productsList;
		//I am going to create a order
		 method(backupBuyProducts); 
		
		
		int sum= (int)	backupBuyProducts.stream().mapToLong(x -> x.getProductPrice()).sum();
		System.out.println("la suma es:"+sum);
		
		System.out.println("vamos a imprimir los precios");
		for(Product alias:backupBuyProducts) {
			alias.setTotal(sum);
			alias.setOrder(inc);
			System.out.println(alias);
		}
		

		System.out.println("prices was finish to print");
		inc++;
		
		addList(backupBuyProducts);
		
		productsList = new ArrayList<Product>();
		
	}
	
	private void method(List<Product> backupBuyProducts2) {
		

		System.out.println("alias IS A TEST a asdasd TO ssdd");
		SessionFactory sFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Order.class).addAnnotatedClass(Product.class)
				.buildSessionFactory();

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

	private void addList(List<Product> backupBuyProducts) {
		registerBuyProducts.add(backupBuyProducts);
		
	}

	@Override
	public List<List<Product>>  GetBuyProduct() {	
		List<Product> butList =  getBuyProductsHibernate();
		return registerBuyProducts;
		
	}

	private List<Product> getBuyProductsHibernate() {
		// TODO Auto-generated method stub
		return null;
	}



}
