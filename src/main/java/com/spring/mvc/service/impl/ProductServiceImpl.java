package com.spring.mvc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.BuyProductDao;
import com.spring.mvc.dao.ProductDao;
import com.spring.mvc.model.Order;
import com.spring.mvc.model.Product;
import com.spring.mvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private  ProductDao productDao;
	@Autowired
	private BuyProductDao buyProductDao;

	@Override
	public List<Product> getProductList() {
		
		return productDao.getProducts();
	}

	@Override
	public List<Product> getSelectedProducts(List<Product> products) {
		List<Product> productFilter = products.stream().filter(x -> x.getEnabled()).collect(Collectors.toList());
		System.out.println(productFilter.size());
//		method();
		return productFilter;
	}

	private void method() {

		

	
		
		System.out.println("TESTING a asdasd TO ssdd");
		SessionFactory sFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Order.class).addAnnotatedClass(Product.class)
				.buildSessionFactory();

		Session session = sFactory.openSession();
		List<Order> results = null;
		try {
			
			
			String hql = "from order where order.orderId = (select max(orderId) from order)";
			System.out.println("este es el query: " + hql);	
		
			Query query = session.createQuery(hql);  
			results = query.getResultList();
			
			results.stream().forEach(x->System.out.println(x));
		/*	Product product = new Product(1,"White patito", "phone001", 400, 18, "no-image.png", true);
			Product product2 = new Product(2,"White patito", "phone002", 400, 18, "no-image.png", true);
			
			Order order = new Order();
			order.add(product);
			order.add(product2);
			order.setName("as");
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
			*/
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

	@Override
	public void saveBuyProducts(List<Product> products) {
		
		buyProductDao.saveBuyProducts(products);
		
	
	}

	@Override
	public List<Product> getBuyProducts() {
		
		return buyProductDao.getBuyProducts();
	}

	@Override
	public List<Product> getProductsHibernate() {
		// TODO Auto-generated method stub
		return productDao.getProductsHibernate();
	}



}
