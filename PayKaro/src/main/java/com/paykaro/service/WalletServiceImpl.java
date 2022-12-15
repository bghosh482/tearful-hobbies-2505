package com.paykaro.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paykaro.model.Customer;
import com.paykaro.model.Wallet;
import com.paykaro.repository.WalletDao;

@Service
public class WalletServiceImpl implements WalletService{

	@Autowired
	private WalletDao Wdao;

	@Override
	public Customer createAccount(String name, String mobileno, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer showBalance(String name, String mobileno, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer fundTransfer(String name, String mobileno, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer depositAccount(String name, String mobileno, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer updateAccount(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addMoney(Wallet wallet, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
