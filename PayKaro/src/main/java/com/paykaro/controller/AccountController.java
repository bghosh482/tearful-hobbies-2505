package com.paykaro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paykaro.exception.AccountException;
import com.paykaro.exception.CustomerException;
import com.paykaro.exception.WalletException;
import com.paykaro.model.Account;
import com.paykaro.service.AccountService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/customers/account")
	public ResponseEntity<Account> addAccountHandler(@RequestBody Account account,
			@RequestParam(required = false) String key) throws CustomerException, WalletException {

		Account savedAccount = accountService.addAccount(account, key);
		return new ResponseEntity<Account>(savedAccount, HttpStatus.CREATED);

	}

	@DeleteMapping("/customers/account")
	public ResponseEntity<Account> removeAccountHandler(@RequestParam(required = false) Integer accId,
			@RequestParam(required = false) String key) throws CustomerException, AccountException, WalletException {

		Account deleteAccount = accountService.removeAccount(accId, key);
		return new ResponseEntity<Account>(deleteAccount, HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Account>> viewAccount(@RequestParam(required = false) Integer walletId,
			@RequestParam(required = false) String key) throws CustomerException, WalletException, AccountException {

		List<Account> accounts = accountService.viewAllAccount(walletId, key);
		return new ResponseEntity<>(accounts, HttpStatus.OK);

	}
}
