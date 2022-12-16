package com.paykaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paykaro.model.Customer;
import com.paykaro.model.Wallet;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
	public Customer findByMobileNo(String mobileNo);

	public Customer findByWallet(Wallet wallet);
}
