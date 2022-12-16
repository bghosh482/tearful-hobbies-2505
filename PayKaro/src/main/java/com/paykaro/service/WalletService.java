package com.paykaro.service;

import java.math.BigDecimal;
import java.util.List;

import com.paykaro.exception.BillPaymentException;
import com.paykaro.exception.CustomerException;
import com.paykaro.exception.WalletException;
import com.paykaro.model.BillPayment;
import com.paykaro.model.Customer;

public interface WalletService {
	public Customer createAccount(String name, String mobile, Double balance, String key)
			throws CustomerException, WalletException;

	public Customer showBalance(String mobileNo, String key) throws CustomerException;

	public String fundTransfer(String sourceMobileno, String targetMobileNo, Double amount, String key)
			throws CustomerException, WalletException;

	public Customer depositAmount(String mobileNo, Double amount, String key) throws CustomerException;

}
