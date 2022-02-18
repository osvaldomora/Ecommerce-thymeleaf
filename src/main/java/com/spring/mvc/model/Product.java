package com.spring.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	@Column
	private String productName;
	@Column
	private String productCategory;
	@Column
	private Long productPrice;
	@Column
	private Long productQuantity;
	@Column
	private String imagen="no-image.png";
	@Column
	private Boolean enabled;
	@Transient
	private int total;
	@Column
	private  Integer order=0;
	
	
	
	public Product(Integer productId, String productName, String productCategory, Long productPrice,
			Long productQuantity, String imagen, Boolean enabled) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.imagen = imagen;
		this.enabled = enabled;
	}
	
	public Product(Integer productId, String productName, String productCategory, Long productPrice,
			Long productQuantity, String imagen) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.imagen = imagen;
		
	}
	
	public Product() {
	
	}


	public Integer getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	public Long getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public  Integer getOrder() {
		return order;
	}

	public  void setOrder(Integer order) {
		this.order = order;
	}

	public  int getTotal() {
		return total;
	}

	public  void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity
				+ ", imagen=" + imagen + ", enabled=" + enabled + ", order=" + order + ", total=" + total+ "]";
	
	}


	


}
