package com.paykaro.service;

import java.util.Optional;

import javax.transaction.TransactionalException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paykaro.exception.CustomerException;
import com.paykaro.exception.WalletException;
import com.paykaro.model.CurrentUserSession;
import com.paykaro.model.Customer;
import com.paykaro.model.Transaction;
import com.paykaro.model.Wallet;
import com.paykaro.repository.CustomerDAO;
import com.paykaro.repository.SessionDAO;
import com.paykaro.repository.TransactionDAO;
import com.paykaro.repository.WalletDAO;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;

	@Autowired
	private SessionDAO sessionDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private WalletDAO walletDAO;

	@Override
	public Transaction addTransaction(Transaction transaction, String key) throws CustomerException, WalletException {
		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please Login first...");
		}
		
		Optional<Customer> customer = customerDAO.findById(loggedInUser.getUserId());
		if (customer.get().getWalletId() != null) {

			Optional<Wallet> savedWallet = walletDAO.findById(customer.get().getWalletId());
			Transaction savedTransaction = transactionDAO.save(transaction);

			savedWallet.get().getTransactions().add(savedTransaction);

			walletDAO.save(savedWallet.get());
			return savedTransaction;

		}

		throw new WalletException("Wallet not exist.first create wallet..");

	}

}
