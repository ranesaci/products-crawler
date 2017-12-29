package com.sachin4java.productscrawler.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sachin4java.productscrawler.model.Product;
import com.sachin4java.productscrawler.model.ProductCrawl;
import com.sachin4java.productscrawler.service.CrawlerService;

@Service
public class CrawlerServiceImpl implements CrawlerService{
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ProductCrawl crawlByProductName(String productname) {
		ProductCrawl productCrawl = new ProductCrawl();
		
		List<ProductCrawl> productCrawls = getCrawlData();
		for (ProductCrawl crawl : productCrawls) {
			if(productname.equalsIgnoreCase(crawl.getProductName())){
				productCrawl=crawl;
				break;
			}
			
		}
				
		return productCrawl;
	}

	private List<ProductCrawl> getCrawlData() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<ProductCrawl>> crawlData = restTemplate.exchange("https://next.json-generator.com/api/json/get/4k2T-g0z4", 
											HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductCrawl>>() {
		            });
		List<ProductCrawl> productCrawls = crawlData.getBody();
		return productCrawls;
	}

	@Override
	public List<ProductCrawl> crawlByCategoryName(String categoryname) {
		List<ProductCrawl> productCrawlsList = new ArrayList<>();
		
		//get json products prices repo
		List<ProductCrawl> productCrawls = getCrawlData();
		
		//call db service to fetch all products by categoryname (REST CALL)
		
		//WITHOUT EUREKA
		List<Product> productList = getProductList(categoryname);
		
		for (Product product : productList) {
			for(ProductCrawl productCrawl : productCrawls) {
				
				if(product.getProductName().equalsIgnoreCase(productCrawl.getProductName())) {
					
					productCrawlsList.add(productCrawl);
				}
				
			}
		}
		
		return productCrawlsList;
	}

	private List<Product> getProductList(String categoryname) {
		
		//Without Eureka
		ResponseEntity<List<Product>> productData = restTemplate.exchange("http://products-db/products/category/"+categoryname, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
							});
			List<Product> products = productData.getBody();
		return null != products? products:Collections.EMPTY_LIST;
	}
	
	

}
