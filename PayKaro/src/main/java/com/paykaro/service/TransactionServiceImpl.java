package com.paykaro.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.TransactionalException;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paykaro.dto.TransactionDTO;
import com.paykaro.model.Transaction;
import com.paykaro.model.Wallet;
import com.paykaro.repository.TransactionDAO;
import com.paykaro.repository.WalletDao;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;
	@Autowired
	private WalletDao walletDao;

	@Override
	public TransactionDTO addTranscation(TransactionDTO tean) throws TransactionalException {
		// TODO Auto-generated method stub
		if (tean == null) {

			throw new TransactionException("please send correct details...");
		}

	 

			Wallet wallet= walletDao.findById(tean.getWalletid()).get();
			
			if(tean.getWalletid()!=wallet.getWid()) {
				
				throw new TransactionException("Invalid wallet id...");
			}
			

			if (wallet.getBalance() < tean.getAmount()) {
				
				throw new TransactionException("Insufficent balance for transaction...");
			}
		 
			wallet.setBalance(wallet.getBalance() - tean.getAmount());
			
			Transaction trans=new Transaction();
			trans.setAmount(tean.getAmount());
			trans.setTransactionType(tean.getDescription());
			trans.setDescription(tean.getDescription());
			trans.setWallet(wallet);
			
			wallet.getTransactions().add(trans);
		       

		      walletDao.save(wallet);
			   
			
		

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
	public List<Transaction> viewTransactionByWallet(Integer wallet_id) throws TransactionalException {
		// TODO Auto-generated method stub
		List<Transaction> list = transactionDAO.findByWalletid(wallet_id);

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

}
