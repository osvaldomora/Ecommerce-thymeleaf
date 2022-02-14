package com.spring.mvc.dto;

import java.util.ArrayList;
import java.util.List;

import com.spring.mvc.model.Product;

public class ProductDto {
	
	private List<Product> products = new ArrayList<Product>();

	public ProductDto(List<Product> products) {	
		this.products = products;
	}

	
	
	public ProductDto() {
		
		// TODO Auto-generated constructor stub
	}



	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}



	@Override
	public String toString() {
		return "ProductDto [products=" + products + "]";
	}


	
		

}
