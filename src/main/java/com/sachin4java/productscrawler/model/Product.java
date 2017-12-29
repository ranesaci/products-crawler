package com.sachin4java.productscrawler.model;

public class Product {
		
	private String categoryName;
	private String productName;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(String categoryName, String productName) {
		this.categoryName = categoryName;
		this.productName = productName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	

}
