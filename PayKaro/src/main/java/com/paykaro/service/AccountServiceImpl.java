package com.paykaro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paykaro.exception.CustomerException;
import com.paykaro.exception.WalletException;
import com.paykaro.model.Account;
import com.paykaro.model.CurrentUserSession;
import com.paykaro.model.Customer;
import com.paykaro.model.Transaction;
import com.paykaro.model.Wallet;
import com.paykaro.repository.AccountDAO;
import com.paykaro.repository.CustomerDAO;
import com.paykaro.repository.SessionDAO;
import com.paykaro.repository.WalletDAO;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private SessionDAO sessionDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private WalletDAO walletDAO;

	@Override
	public Account addAccount(Account account, String key) throws CustomerException, WalletException {
		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to  add bank account...");
		}

		Optional<Customer> customer = customerDAO.findById(loggedInUser.getUserId());
		if (customer.get().getWalletId() != null) {

			Optional<Wallet> savedWallet = walletDAO.findById(customer.get().getWalletId());
			Account savedAccount = accountDAO.save(account);
			savedWallet.get().getAccouonts().add(savedAccount);

			walletDAO.save(savedWallet.get());
			return savedAccount;

		}

		throw new WalletException("Wallet not exist.first create wallet..");

	}

}
