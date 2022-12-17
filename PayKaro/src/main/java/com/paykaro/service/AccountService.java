package com.paykaro.service;

import java.util.List;

import com.paykaro.model.Account;
import com.paykaro.model.Wallet;

public interface AccountService {
	
	public Wallet addAccount(Account acc,Integer walletid);

	public Wallet removeAccount(Account acc);
	
	public Account viewAccount(Integer walletid,Integer accountid);
	
	public List<Account> viewAllAccounts(Integer walletid);
}
