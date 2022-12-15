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

		Optional<Customer> customer = customerDAO.findById(loggedInUser.getUserId());
		if (customer.get().getWalletId() != null) {

			Optional<Wallet> savedWallet = walletDAO.findById(customer.get().getWalletId());

			BillPayment savedBillPayment = billPaymentDAO.save(billPayment);

			savedWallet.get().getBillPayments().add(billPayment);
			walletDAO.save(savedWallet.get());
			return savedBillPayment;

		}

		throw new WalletException("Wallet not exist.first create wallet..");

	}

	@Override
	public List<BillPayment> viewAllBillPayments(String key)
			throws CustomerException, WalletException, BillPaymentException {
		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key ");
		}

		Customer customer = customerDAO.findById(loggedInUser.getUserId())
				.orElseThrow(() -> new CustomerException("No customer found..."));

		Wallet savedWallet = walletDAO.findById(customer.getWalletId())
				.orElseThrow(() -> new WalletException("create wallet first"));

		if (savedWallet.getBillPayments().isEmpty())
			throw new BillPaymentException("No payment found...");
		return savedWallet.getBillPayments();
	}

}