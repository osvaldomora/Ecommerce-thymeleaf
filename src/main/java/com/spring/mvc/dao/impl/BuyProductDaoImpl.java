package com.spring.mvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mvc.dao.BuyProductDao;
import com.spring.mvc.model.Product;


@Repository
public class BuyProductDaoImpl implements BuyProductDao{

	List<Product> productsList = new ArrayList();

	@Override
	public void saveBuyProducts(List<Product> products) {
		for(Product alias: products)
			productsList.add(alias);
		
	}

	@Override
	public List<Product> getBuyProducts() {
		productsList.forEach(x->System.out.println(x));
		return productsList;
	}


}
