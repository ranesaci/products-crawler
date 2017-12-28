package com.sachin4java.productscrawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sachin4java.productscrawler.model.ProductCrawl;
import com.sachin4java.productscrawler.service.CrawlerService;

@Service
public class CrawlerServiceImpl implements CrawlerService{
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ProductCrawl crawlByProductName(String productname) {
		ProductCrawl productCrawl = new ProductCrawl();
		
		ResponseEntity<List<ProductCrawl>> rateResponse = restTemplate.exchange("https://next.json-generator.com/api/json/get/4k2T-g0z4", 
											HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductCrawl>>() {
		            });
		List<ProductCrawl> productCrawls = rateResponse.getBody();
		for (ProductCrawl crawl : productCrawls) {
			if(productname.equalsIgnoreCase(crawl.getProductName())){
				productCrawl=crawl;
				break;
			}
			
		}
				
		return productCrawl;
	}
	
	

}
