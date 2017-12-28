package com.sachin4java.productscrawler.bo;

import com.sachin4java.productscrawler.model.ProductCrawl;

public interface CrawlerBO {

	ProductCrawl crawlByProductName(String productname);

}
