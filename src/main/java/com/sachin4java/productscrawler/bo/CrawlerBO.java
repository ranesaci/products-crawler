package com.sachin4java.productscrawler.bo;

import java.util.List;

import com.sachin4java.productscrawler.model.ProductCrawl;

public interface CrawlerBO {

	ProductCrawl crawlByProductName(String productname);

	List<ProductCrawl> crawlByCategoryName(String categoryname);

}
