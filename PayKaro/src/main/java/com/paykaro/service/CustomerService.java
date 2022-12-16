package com.paykaro.service;

import com.paykaro.exception.CustomerException;
import com.paykaro.model.Customer;

public interface CustomerService {
	public Customer createCustomer(Customer customer) throws CustomerException;

	public Customer updateCustomer(Customer customer, String key) throws CustomerException;

}
