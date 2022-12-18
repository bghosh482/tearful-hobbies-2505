package com.paykaro.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.TransactionalException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paykaro.exception.TransactionException;
import com.paykaro.model.Transaction;
import com.paykaro.model.TransactionDTO;
import com.paykaro.model.Wallet;
import com.paykaro.repository.TransactionDAO;
import com.paykaro.repository.WalletDAO;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDAO;
	@Autowired
	private WalletDAO walletDao;

	@Override
	public TransactionDTO addTranscation(TransactionDTO tean) throws TransactionalException, TransactionException {
		// TODO Auto-generated method stub
		if (tean == null) {

			throw new TransactionException("please send correct details...");
		}

		Wallet wallet = walletDao.findById(tean.getWalletid()).get();

		if (tean.getWalletid() != wallet.getWid()) {

			throw new TransactionException("Invalid wallet id...");
		}

		if (wallet.getBalance() < tean.getAmount()) {

			throw new TransactionException("Insufficent balance for transaction...");
		}

		wallet.setBalance(wallet.getBalance() - tean.getAmount());

		Transaction trans = new Transaction();
		trans.setAmount(tean.getAmount());
		trans.setTransactionType(tean.getTransactionType());
		trans.setDescription(tean.getDescription());
		trans.setWallet(wallet);

		wallet.getTransactions().add(trans);

		walletDao.save(wallet);

		return tean;
	}

	@Override
	public List<Transaction> viewTransactionByDate(String from, String to)
			throws TransactionalException, TransactionException {
		// TODO Auto-generated method stub
		LocalDate localDate = LocalDate.parse(from);
		LocalDate localDate1 = LocalDate.parse(to);
		List<Transaction> list = transactionDAO.viewTransactionByDate(from, to);
		if (list.size() == 0) {
			throw new TransactionException("No Transcation done between  these dates");
		}

		return list;
	}

	@Override
	public List<Transaction> viewTransactionByWallet(Integer wallet_id)
			throws TransactionalException, TransactionException {
		// TODO Auto-generated method stub
		List<Transaction> list = transactionDAO.findByWalletid(wallet_id);

		if (list.size() == 0) {
			throw new TransactionException("No Transcation done between  these dates");
		}

		return list;
	}

	@Override
	public List<Transaction> viewALLTransaction(String type) throws TransactionalException, TransactionException {
		// TODO Auto-generated method stub
		List<Transaction> list = transactionDAO.findByTransactionType(type);

		if (list.size() == 0) {
			throw new TransactionException("No Transcation done between  these dates");
		}

		return list;

	}

}
