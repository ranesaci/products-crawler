package com.sachin4java.productscrawler.controller;

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
	
	@GetMapping("/{productname}")
	public ProductCrawl crawlByProductName(@PathVariable String productname) {
		
		ProductCrawl productCrawl = crawlerBO.crawlByProductName(productname);
		return productCrawl;
		
	}
}
