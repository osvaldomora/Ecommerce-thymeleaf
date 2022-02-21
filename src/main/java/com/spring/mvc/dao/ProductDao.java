package com.spring.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mvc.model.Product;

@Repository
public interface ProductDao {

	List<Product> getProducts();

	List<Product> getProductsHibernate();

}
