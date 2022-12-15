package com.paykaro.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.TransactionalException;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paykaro.model.Transaction;
import com.paykaro.model.Wallet;
import com.paykaro.repository.TransactionDAO;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;

	@Override
	public Transaction addTranscation(Transaction tean) throws TransactionalException {
		// TODO Auto-generated method stub
		if(tean==null) {
			
			throw new TransactionException("please send correct details...");
		}
		 
		Wallet wallet=tean.getWallet();
		wallet.getTransactions().add(tean);
		
		transactionDAO.save(tean);
		
			
		 
		

		return tean;
	}

	@Override
	public List<Transaction> viewTransactionByDate(LocalDate from, LocalDate to) throws TransactionalException {
		// TODO Auto-generated method stub
		List<Transaction> list = transactionDAO.viewTransactionByDate(from, to);
		if (list.size() == 0) {
			throw new TransactionException("No Transcation done between  these dates");
		}

		return list;
	}

	@Override
	public List<Transaction> viewALLTransaction(String type) throws TransactionalException {
		// TODO Auto-generated method stub

		List<Transaction> list = transactionDAO.findByTransactionType(type);
		if (list.size() == 0) {
			throw new TransactionException("No Transcation done between  these dates");
		}
		return list;
	}

	@Override
	public List<Transaction> viewTransactionByWallet(Integer wallet_id) throws TransactionalException {
		// TODO Auto-generated method stub
		List<Transaction> list = transactionDAO.findByWalletid(wallet_id);

		if (list.size() == 0) {
			throw new TransactionException("No Transcation done between  these dates");
		}

		return list;
	}

}
