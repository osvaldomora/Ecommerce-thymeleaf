package com.spring.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.ProductDao;
import com.spring.mvc.model.Product;
import com.spring.mvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    
	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productDao.getProducts();
	}

}
