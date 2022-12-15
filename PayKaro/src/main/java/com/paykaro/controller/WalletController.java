package com.paykaro.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paykaro.exception.CustomerException;
import com.paykaro.exception.WalletException;
import com.paykaro.model.Customer;
import com.paykaro.service.WalletService;

@RestController
public class WalletController {

	@Autowired
	private WalletService walletService;

	@PostMapping("/customers/wallet")
	public ResponseEntity<Customer> createWalletHandler(@RequestParam(required = false) String name,
			@RequestParam(required = false) String mobile, @RequestParam(required = false) Double balance,
			@RequestParam(required = false) String key) throws CustomerException, WalletException {
		Customer savedCustomer = walletService.createAccount(name, mobile, balance, key);

		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.OK);

	}

}
