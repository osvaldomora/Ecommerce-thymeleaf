package com.spring.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.mvc.model.Product;
import com.spring.mvc.service.ProductService;

@Controller
public class ProductController {
    @Autowired
	ProductService productService;
	List<Product> productList = new ArrayList<>();
	
	@GetMapping("/getProducts")
	public String getAllProducts(Model model) {
		List<Product> productsList = productService.getProductList();
		productsList.forEach(x->System.out.println(x));
		model.addAttribute("productsList", productsList);
		
//		Map<String,List<Product>> productMap = new HashMap<>();
//		model.addAllAttributes(productMap);
		return "productView";
	}
	
	
}
