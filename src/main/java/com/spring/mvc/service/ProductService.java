package com.spring.mvc.service;

import java.util.List;

import com.spring.mvc.model.Product;

public interface ProductService {

	List<Product> getProductList();
	
	List<Product> getSelectedProducts(List<Product> products);
	
	public void saveBuyProducts(List<Product> products);
	
	public List<Product> getBuyProducts();

	List<Product> getProductsHibernate();

}
