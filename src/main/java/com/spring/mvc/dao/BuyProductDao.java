package com.spring.mvc.dao;

import java.util.List;

import com.spring.mvc.model.Product;

public interface BuyProductDao {
	
	public void saveBuyProducts(List<Product> products);
	
	public List<Product> getBuyProducts();
	
	public void clearBuyProduct();
	
	public List<Product> GetBuyProduct(); 

}
