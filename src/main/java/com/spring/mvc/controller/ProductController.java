package com.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.dao.BuyProductDao;
import com.spring.mvc.dto.ProductDto;
import com.spring.mvc.model.Product;
import com.spring.mvc.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private BuyProductDao buyProductDao;

	List<Product> productList = new ArrayList<>();

	@GetMapping("/getProducts")
	public String getAllProducts(Model model) {
		List<Product> productsList = productService.getProductList();
		ProductDto productDto = new ProductDto(productsList);
		model.addAttribute("productDto", productDto);

		return "productView";
	}

	@GetMapping("/getSelectProducts")
	public String getSelectProducts(@ModelAttribute ProductDto productDto, Model model) {

		System.out.println("filter products:");
		productService.getSelectedProducts(productDto.getProducts()).forEach(x -> System.out.println(x));
		List<Product> productsList = productService.getSelectedProducts(productDto.getProducts());
		buyProductDao.saveBuyProducts(productsList);
		model.addAttribute("productsList", buyProductDao.getBuyProducts());

		return "selectedProduct";
	}
	
	

	@PostMapping("/buy")
	public String buyProducts(RedirectAttributes attributes) {

		System.out.println("buy products:");
		buyProductDao.clearBuyProduct();
		attributes.addFlashAttribute("message", "The purchase was made correctly");
		return "redirect:/getProducts";
	}

	@GetMapping("/search")
	public String buscar(@ModelAttribute("search") Product product, Model model) {
		System.out.println("search by ss : " + product);
		List<Product> productsList = productService.getProductList();
		List<Product> productsFilter = productsList.stream()
				.filter(pro -> pro.getProductName().contains(product.getProductName())).collect(Collectors.toList());

		System.out.println("filtering");
		productsFilter.forEach(x -> System.out.println(x));

		ProductDto productDto = new ProductDto(productsFilter);
		model.addAttribute("productDto", productDto);

		return "/productView";
	}

	@GetMapping("/shoppingList")
	public String shoppingList(Model model) {
		System.out.println("shoppingList");

		List<Product> productsList = buyProductDao.GetBuyProduct();
		model.addAttribute("productsList", productsList);
		return "shopppingList";
	}

}
