package com.spring.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
//	@Transient
//	private int total;
//	@Transient
//	private  Integer order=0;
	
	
	public Product() {

	}
	
	public Product(Integer productId, String productName, String productCategory, int i,
			int j, String imagen, Boolean enabled) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = (long) i;
		this.productQuantity = (long) j;
		this.imagen = imagen;
		this.enabled = enabled;
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

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity
				+ ", imagen=" + imagen + ", enabled=" + enabled + "]";
	}



	


}
