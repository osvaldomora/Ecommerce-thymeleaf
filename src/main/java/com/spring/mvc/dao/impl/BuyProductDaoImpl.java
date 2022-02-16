package com.spring.mvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

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
	long sum=	backupBuyProducts.stream().mapToLong(x -> x.getProductPrice()).sum();
	System.out.println("la suma es:"+sum);
		for(Product alias:backupBuyProducts) {
			alias.setProductPrice(sum);;
		}
		
//		
		
		Product.setOrder(Product.getOrder()+1);
		addList(backupBuyProducts);
		
		productsList = new ArrayList<Product>();
		
	}
	
	private void addList(List<Product> backupBuyProducts) {
		registerBuyProducts.add(backupBuyProducts);
		
	}

	@Override
	public List<List<Product>>  GetBuyProduct() {	

		return registerBuyProducts;
		
	}


}
