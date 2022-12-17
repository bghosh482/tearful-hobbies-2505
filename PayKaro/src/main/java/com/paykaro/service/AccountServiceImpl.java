package com.paykaro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.paykaro.model.Account;
import com.paykaro.model.Wallet;
import com.paykaro.repository.AccountDAO;
import com.paykaro.repository.WalletDAO;

public class AccountServiceImpl implements AccountService {
    @Autowired
	private WalletDAO walletDAO;
	@Autowired
    private AccountDAO accountDAO;
    
	@Override
	public Wallet addAccount(Account acc,Integer wallid) {
        
		Account ac= accountDAO.save(acc);
		 Optional<Wallet> wlWallet= walletDAO.findById(wallid);
		
		 wlWallet.get().getAccouonts().add(ac);
		 
	   walletDAO.save(wlWallet.get());
		
		return wlWallet.get();
	}

	@Override
	public Wallet removeAccount(Account acc) {
		
		return null;
	}

	@Override
	public Account viewAccount(Integer walletid,Integer accountid) {
		
		return null;
	}

	@Override
	public List<Account> viewAllAccounts(Integer walletid) {
		
		
		
		return null;
	}

}
