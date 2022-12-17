package com.paykaro.service;

import javax.transaction.TransactionalException;

import com.paykaro.exception.CustomerException;
import com.paykaro.exception.WalletException;
import com.paykaro.model.Transaction;

public interface TransactionService {

	public Transaction addTransaction(Transaction transaction, String key) throws CustomerException, WalletException;

}
