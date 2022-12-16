package com.paykaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paykaro.model.Transaction;


@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer> {

}
