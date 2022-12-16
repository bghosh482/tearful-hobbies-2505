package com.paykaro.service;

import java.math.BigDecimal;
import java.util.List;

import com.paykaro.model.Customer;
import com.paykaro.model.Wallet;

public interface WalletService {

	public Customer createAccount(String name,String mobileno,BigDecimal amount);
	
	public Customer showBalance(String name,String mobileno,BigDecimal amount);
	
	public Customer fundTransfer(String name,String mobileno,BigDecimal amount);

	public Customer depositAccount(String name,String mobileno,BigDecimal amount);

	public List<Customer> getList();

	public Customer updateAccount(Customer customer);
	
	public Customer addMoney(Wallet wallet,Double amount);


}
