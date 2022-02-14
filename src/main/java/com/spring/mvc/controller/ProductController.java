package com.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.mvc.dao.BuyProductDao;
import com.spring.mvc.dto.ProductDto;
import com.spring.mvc.model.Product;
import com.spring.mvc.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	@Qualifier("productServiceImpl")
	private BuyProductDao buyProductDao;
	
	List<Product> productList = new ArrayList<>();

	@GetMapping("/getProducts")
	public String getAllProducts(Model model) {
		List<Product> productsList = productService.getProductList();
		ProductDto productDto = new ProductDto(productsList);
		model.addAttribute("productDto", productDto);

		return "productView";
	}

	@PostMapping("/getSelectProducts")
	public String getSelectProducts( @ModelAttribute ProductDto productDto,Model model) {

		System.out.println("filter products:");
		productService.getSelectedProducts(productDto.getProducts()).forEach(x -> System.out.println(x));
		List<Product> productsList = productService.getSelectedProducts(productDto.getProducts());
		buyProductDao.saveBuyProducts(productsList);
		model.addAttribute("productsList", buyProductDao.getBuyProducts());

		return "selectedProduct";
	}
	
	

}
