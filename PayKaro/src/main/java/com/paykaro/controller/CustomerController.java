package com.paykaro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paykaro.model.Customer;
import com.paykaro.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomerHandler(@RequestBody Customer customer) {
		Customer savedCustomer = customerService.registerCustomer(customer);
		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);

	}

}
