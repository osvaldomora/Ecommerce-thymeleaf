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

		return productFilter;
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
