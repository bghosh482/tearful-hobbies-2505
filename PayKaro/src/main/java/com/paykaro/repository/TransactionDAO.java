package com.paykaro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.paykaro.model.Transaction;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer> {

	@Query("select w.transactions from Wallet w where w.wid=?1")
	public List<Transaction> findByWalletid(int wallet_id);

	@Query("select t from Transaction t where t.transactionDate<=?1 and t.transactionDate>=?2 ")
	public List<Transaction> viewTransactionByDate(String from, String to);

	public List<Transaction> findByTransactionType(String type);

}
