package com.spring.mvc.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Order1")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	@Column(name="nameOrder")
	private String name;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="OrderLine",
			   joinColumns = @JoinColumn(name="orderId"),
			   inverseJoinColumns = @JoinColumn(name="productId")			
			)
	private List<Product> products;

    
	
	@Transient
	private int total;
	
	
	public Order() {

	}
	
	




	public Order(String name, List<Product> products) {
		super();
		
		this.name = name;
		this.products = products;
	}






	public Integer getOrderId() {
		return orderId;
	}




	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public List<Product> getProducts() {
		return products;
	}




	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void add(Product tempProduct) {
		if (products == null) {
			products = new LinkedList<Product>();
		}
		products.add(tempProduct);
	}






	public int getTotal() {
		return total;
	}






	public void setTotal(int total) {
		this.total = total;
	}






	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", name=" + name + ", products=" + products + ", total=" + total + "]";
	}




    
     



        
	


}
