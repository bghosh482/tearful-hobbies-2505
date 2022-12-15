package com.paykaro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paykaro.exception.CustomerException;
import com.paykaro.model.CurrentUserSession;
import com.paykaro.model.Customer;
import com.paykaro.repository.CustomerDAO;
import com.paykaro.repository.SessionDAO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private SessionDAO sessionDAO;

	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {

		Customer existingCustomer = customerDAO.findByMobileNo(customer.getMobileNo());

		if (existingCustomer != null)
			throw new CustomerException("Customer Already Registered with Mobile number");

		return customerDAO.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}

		if (customer.getCid() == loggedInUser.getUserId()) {
			// If LoggedInUser id is same as the id of supplied Customer which we want to
			// update
			return customerDAO.save(customer);
		} else
			throw new CustomerException("Invalid Customer Details, please login first");

	}

}
