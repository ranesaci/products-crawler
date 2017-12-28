package com.sachin4java.productscrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductsCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsCrawlerApplication.class, args);
	}
	
	@Bean
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
}
