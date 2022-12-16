package com.paykaro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paykaro.exception.BillPaymentException;
import com.paykaro.exception.CustomerException;
import com.paykaro.exception.WalletException;
import com.paykaro.model.BillPayment;
import com.paykaro.model.CurrentUserSession;
import com.paykaro.model.Customer;
import com.paykaro.model.Transaction;
import com.paykaro.model.Wallet;
import com.paykaro.repository.BillPaymentDAO;
import com.paykaro.repository.CustomerDAO;
import com.paykaro.repository.SessionDAO;
import com.paykaro.repository.WalletDAO;

@Service
public class BillPaymentServiceImpl implements BillPaymentService {

	@Autowired
	private BillPaymentDAO billPaymentDAO;

	@Autowired
	private SessionDAO sessionDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private WalletDAO walletDAO;

	@Override
	public BillPayment addBillPayment(BillPayment billPayment, String key)
			throws BillPaymentException, CustomerException, WalletException {
		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please Login first...");
		}

		walletDAO.findById(billPayment.getWallet().getWid())
				.orElseThrow(() -> new WalletException("wallet does not exist..."));
		return billPaymentDAO.save(billPayment);
	}

	@Override
	public List<BillPayment> viewAllBillPayments(String key)
			throws CustomerException, WalletException, BillPaymentException {
		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key ");
		}

		customerDAO.findById(loggedInUser.getUserId()).get().getWallet();

		List<BillPayment> billPayments = billPaymentDAO
				.findByWallet(customerDAO.findById(loggedInUser.getUserId()).get().getWallet());

		return billPayments;

	}

}
