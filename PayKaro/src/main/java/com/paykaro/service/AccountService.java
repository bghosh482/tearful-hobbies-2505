package com.paykaro.service;

import com.paykaro.exception.AccountException;
import com.paykaro.exception.CustomerException;
import com.paykaro.exception.WalletException;
import com.paykaro.model.Account;

public interface AccountService {
	public Account addAccount(Account account, String key) throws CustomerException, WalletException;

	public Account removeAccount(Account account, String key) throws CustomerException, AccountException;
}
