package com.sachin4java.productscrawler.model;

import java.util.Map;

public class ProductCrawl {
	
	private String productName;
	private Map<String, String> prices;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Map<String, String> getPrices() {
		return prices;
	}
	public void setPrices(Map<String, String> prices) {
		this.prices = prices;
	}
	
	

}
