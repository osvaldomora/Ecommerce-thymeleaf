package com.spring.mvc.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.mvc.model.Product;
import com.spring.mvc.service.ProductService;

public class Test {
	@Autowired
	private static ProductService productService;
	public static void main(String[] args) {

		Product product1 = new  Product();
		product1.setProductId(1);
		product1.setProductName("Samgung");
		product1.setProductCategory("phone");
		product1.setProductPrice(1000L);
		product1.setProductQuantity(10L);
		
		Product product2 = new  Product();
		product2.setProductId(2);
		product2.setProductName("Patito");
		product2.setProductCategory("phone");
		product2.setProductPrice(300L);
		product2.setProductQuantity(8L);
		
		Product product3 = new  Product();
		product3.setProductId(3);
		product3.setProductName("Apple");
		product3.setProductCategory("phone");
		product3.setProductPrice(300L);
		product3.setProductQuantity(8L);
		
		Product product4 = new  Product();
		product4.setProductId(4);
		product4.setProductName("Sony");
		product4.setProductCategory("phone");
		product4.setProductPrice(200L);
		product4.setProductQuantity(18L);
		
		Product product5 = new  Product();
		product5.setProductId(5);
		product5.setProductName("White Patito ");
		product5.setProductCategory("phone");
		product5.setProductPrice(200L);
		product5.setProductQuantity(18L);
		
		List<Product> productList = Arrays.asList(product1,product2,product3,product4,product5);
		
		List<Product> productsFilter = productList.stream().filter(pro->pro.getProductCategory().contains(pro.getProductCategory())).collect(Collectors.toList());
		
		
		String ca= " la cadena";
		System.out.println(ca.contains("cad"));
		

	}

}
