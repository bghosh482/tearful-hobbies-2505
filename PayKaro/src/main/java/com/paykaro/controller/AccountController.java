package com.paykaro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
