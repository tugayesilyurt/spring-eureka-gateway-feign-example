package com.product.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.service.entity.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

	private final static List<Product> products = new ArrayList<>();

	static {
		products.add(new Product(1l, "kitap"));
		products.add(new Product(2l, "laptop"));
		products.add(new Product(3l, "klavye"));
		products.add(new Product(4l, "masa"));
	}
	
	@GetMapping("/product-detail/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id)
	{
		Product product = products.stream().filter(item -> item.getId() == id).findFirst().orElseThrow(() ->  new RuntimeException("not exist!"));
		log.info("Product id : {}", product.getId());
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

}
