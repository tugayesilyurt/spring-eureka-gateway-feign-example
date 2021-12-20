package com.customer.service.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.customer.service.entity.Product;

@Component
@FeignClient("PRODUCT-SERVICE")
public interface ProductServiceClient {
	
	@GetMapping(value = "/api/v1/product-detail/{id}")
	Product findById(@PathVariable("id") Long id);

}
