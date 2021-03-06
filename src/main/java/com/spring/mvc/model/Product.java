package com.spring.mvc.model;



public class Product {
	
	
	private Integer productId;
	private String productName;
	private String productCategory;
	private Long productPrice;
	private Long productQuantity;
	private String imagen="no-image.png";
	private Boolean enabled;
	
	
	
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


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity
				+ ", imagen=" + imagen + ", enabled=" + enabled + "]";
	}

	


}
