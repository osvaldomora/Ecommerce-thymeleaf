package com.spring.mvc.model;

import java.util.List;

public class Order {

	
	public static int  numberOrder=0;
	List<List<Product>> registerBuyProducts;
	public static int getNumberOrder() {
		return numberOrder;
	}
	public static void setNumberOrder(int numberOrder) {
		Order.numberOrder = numberOrder;
	}
	public List<List<Product>> getRegisterBuyProducts() {
		return registerBuyProducts;
	}
	public void setRegisterBuyProducts(List<List<Product>> registerBuyProducts) {
		this.registerBuyProducts = registerBuyProducts;
	}
	
}
