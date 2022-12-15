package com.paykaro.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.TransactionalException;

import com.paykaro.dto.TransactionDTO;
import com.paykaro.model.Transaction;
import com.paykaro.model.Wallet;

public interface TransactionService {
	
	
	public TransactionDTO addTranscation(TransactionDTO tean) throws TransactionalException;
	
	public List<Transaction> viewTransactionByWallet(Integer wallet_id) throws TransactionalException;
	
	public List<Transaction> viewTransactionByDate(LocalDate from,LocalDate to)throws TransactionalException;
	
	public List<Transaction> viewALLTransaction(String type)throws TransactionalException;
	
	 
	

}
