package com.paykaro.service;

import java.util.List;

import com.paykaro.model.Account;
import com.paykaro.model.Wallet;

public interface AccountService {
	
	public Wallet addAccount(Account acc);

	public Wallet removeAccount(Account acc);
	
	public Account viewAccount(Wallet wallet);
	
	public List<Account> viewAllAccounts(Wallet wallet);
}
