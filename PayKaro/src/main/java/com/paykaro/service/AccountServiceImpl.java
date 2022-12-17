package com.paykaro.service;

import java.util.List;
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

		account.setWallet(wallet);

		Account savedAccount = accountDAO.save(account);

		wallet.getAccounts().add(savedAccount);
		walletDAO.save(wallet);
		return savedAccount;

	}

	@Override
	public Account removeAccount(Integer accId, String key)
			throws CustomerException, AccountException, WalletException {
		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to  add bank account...");
		}
		Account savedAccount = accountDAO.findById(accId)
				.orElseThrow(() -> new AccountException("No account found..."));

		Wallet existingWallet = walletDAO.findById(savedAccount.getWallet().getWid())
				.orElseThrow(() -> new WalletException("No wallet found..."));
		existingWallet.getAccounts().remove(savedAccount);

		return savedAccount;

	}

	@Override
	public List<Account> viewAllAccount(Integer walletId, String key)
			throws CustomerException, WalletException, AccountException {
		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to  add bank account...");
		}
		Wallet existingWallet = walletDAO.findById(walletId)
				.orElseThrow(() -> new WalletException("wallet not found..."));
		if (existingWallet.getAccounts().isEmpty())
			throw new AccountException("NO account found...");
		return existingWallet.getAccounts();
	}

}
