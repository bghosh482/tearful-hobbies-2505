package com.paykaro.service;

import java.util.List;

import javax.transaction.TransactionalException;

import com.paykaro.exception.CustomerException;
import com.paykaro.exception.TransactionException;
import com.paykaro.exception.WalletException;
import com.paykaro.model.Transaction;
import com.paykaro.model.TransactionDTO;

public interface TransactionService {

	public TransactionDTO addTranscation(TransactionDTO tean) throws TransactionalException, TransactionException;

	public List<Transaction> viewTransactionByWallet(Integer wallet_id)
			throws TransactionalException, TransactionException;

	public List<Transaction> viewTransactionByDate(String from, String to)
			throws TransactionalException, TransactionException;

	public List<Transaction> viewALLTransaction(String type) throws TransactionalException, TransactionException;

}
