package com.sachin4java.productscrawler.service;

import com.sachin4java.productscrawler.model.ProductCrawl;

public interface CrawlerService {

	ProductCrawl crawlByProductName(String productname);

}
