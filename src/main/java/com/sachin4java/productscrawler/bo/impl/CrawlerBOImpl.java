package com.sachin4java.productscrawler.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sachin4java.productscrawler.bo.CrawlerBO;
import com.sachin4java.productscrawler.model.ProductCrawl;
import com.sachin4java.productscrawler.service.CrawlerService;


@Component
public class CrawlerBOImpl implements CrawlerBO{
	
	@Autowired
	private CrawlerService crawlerService;

	@Override
	public ProductCrawl crawlByProductName(String productname) {
		return crawlerService.crawlByProductName(productname);
	}

	@Override
	public List<ProductCrawl> crawlByCategoryName(String categoryname) {
	  return crawlerService.crawlByCategoryName(categoryname);
	}

}
