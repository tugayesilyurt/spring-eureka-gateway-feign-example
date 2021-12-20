package com.customer.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.service.entity.CustomerOrder;
import com.customer.service.entity.Product;
import com.customer.service.feign.client.ProductServiceClient;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

	private final ProductServiceClient productServiceClient;
	
	private final static List<CustomerOrder> customerOrder = new ArrayList<>();

	static {
		customerOrder.add(new CustomerOrder(1l, 4l,1l,null));
		customerOrder.add(new CustomerOrder(2l, 3l,2l,null));
		customerOrder.add(new CustomerOrder(3l, 2l,3l,null));
		customerOrder.add(new CustomerOrder(4l, 1l,4l,null));
	}
	
	@GetMapping(value="/order/{customerid}")
	public ResponseEntity<?> getCustomerOrder(@PathVariable("customerid") Long customerId)
	{
		CustomerOrder cOrder = customerOrder.stream().filter(item -> item.getCustomerId() == customerId).findFirst().orElseThrow(() -> new RuntimeException("Not Exist!"));
		
		Product product = productServiceClient.findById(cOrder.getProductId());
		cOrder.setProductName(null != product ? product.getName() : StringUtils.EMPTY);
		
		return new ResponseEntity<CustomerOrder>(cOrder, HttpStatus.OK);
	}

}
