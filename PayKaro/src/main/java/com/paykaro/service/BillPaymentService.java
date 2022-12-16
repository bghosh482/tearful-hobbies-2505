package com.paykaro.service;

import java.util.List;

import com.paykaro.exception.BillPaymentException;
import com.paykaro.exception.CustomerException;
import com.paykaro.exception.WalletException;
import com.paykaro.model.BillPayment;

public interface BillPaymentService {
	public BillPayment addBillPayment(BillPayment billPayment, String key)
			throws BillPaymentException, CustomerException, WalletException;

	public List<BillPayment> viewAllBillPayments(String key)
			throws CustomerException, WalletException, BillPaymentException;

}
