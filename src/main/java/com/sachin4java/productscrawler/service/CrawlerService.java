package com.sachin4java.productscrawler.service;

import java.util.List;

import com.sachin4java.productscrawler.model.ProductCrawl;

public interface CrawlerService {

	ProductCrawl crawlByProductName(String productname);

	List<ProductCrawl> crawlByCategoryName(String categoryname);

}
