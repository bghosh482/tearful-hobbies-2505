package com.paykaro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paykaro.exception.AccountException;
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
	private WalletDAO walletDAO;

	@Override
	public Account addAccount(Account account, String key) throws CustomerException, WalletException {
		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to  add bank account...");
		}

		Wallet wallet = walletDAO.findById(account.getWallet().getWid())
				.orElseThrow(() -> new WalletException("wallet does not exist"));

		wallet.getAccounts().add(account);
		walletDAO.save(wallet);
		return account;

	}

	@Override
	public Account removeAccount(Account account, String key) throws CustomerException, AccountException {
		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to  add bank account...");
		}
		Account savedAccount = accountDAO.findById(account.getAccId())
				.orElseThrow(() -> new AccountException("No account found..."));

		accountDAO.delete(savedAccount);
		return savedAccount;

	}

}
