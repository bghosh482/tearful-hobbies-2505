package com.paykaro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paykaro.exception.CustomerException;
import com.paykaro.exception.WalletException;
import com.paykaro.model.Transaction;
import com.paykaro.service.TransactionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/customer/transaction")
	public ResponseEntity<Transaction> createTransactionHandler(@RequestBody Transaction transaction,
			@RequestParam(required = false) String key) throws CustomerException, WalletException {
		Transaction savedTransaction = transactionService.addTransaction(transaction, key);
		return new ResponseEntity<Transaction>(savedTransaction, HttpStatus.OK);
	}
}
