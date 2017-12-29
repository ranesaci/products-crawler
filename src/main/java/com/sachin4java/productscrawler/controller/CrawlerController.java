package com.sachin4java.productscrawler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin4java.productscrawler.bo.CrawlerBO;
import com.sachin4java.productscrawler.model.ProductCrawl;

@RestController
@RequestMapping("/crawlers")
public class CrawlerController {
	
	@Autowired
	private CrawlerBO crawlerBO;
	
	@GetMapping("products/{productname}")
	public ProductCrawl crawlByProductName(@PathVariable String productname) {
		
		ProductCrawl productCrawl = crawlerBO.crawlByProductName(productname);
		return productCrawl;
		
	}
	@GetMapping("categories/{categoryname}")
	public List<ProductCrawl> crawlByCategoryName(@PathVariable String categoryname) {
		
		List<ProductCrawl> productCrawls = crawlerBO.crawlByCategoryName(categoryname);
		return productCrawls;
		
	}
}
