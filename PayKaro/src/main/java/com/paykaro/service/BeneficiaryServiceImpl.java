package com.paykaro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paykaro.exception.BeneficiaryException;
import com.paykaro.exception.CustomerException;
import com.paykaro.model.Beneficiary;
import com.paykaro.model.CurrentUserSession;
import com.paykaro.model.Customer;
import com.paykaro.repository.BeneficiaryDAO;
import com.paykaro.repository.CustomerDAO;
import com.paykaro.repository.SessionDAO;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired
	private SessionDAO sessionDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private BeneficiaryDAO beneficiaryDAO;

	@Override
	public Beneficiary addBeneficiary(Beneficiary beneficiary, String key)
			throws BeneficiaryException, CustomerException {

		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to  add beneficiary...");
		}

		Optional<Customer> customer = customerDAO.findById(loggedInUser.getUserId());

		Beneficiary savedBeneficiary = beneficiaryDAO.save(beneficiary);
		customer.get().getBenificiaries().add(beneficiary);
		customerDAO.save(customer.get());
		return beneficiary;

	}

	@Override
	public Beneficiary deleteBeneficiary(Beneficiary beneficiary, String key) throws CustomerException {
		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to  add beneficiary...");
		}

		beneficiaryDAO.delete(beneficiary);


		return beneficiary;
	}

}
