package com.paykaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paykaro.model.Account;
import com.paykaro.model.Wallet;

public interface WalletDAO extends JpaRepository<Wallet, Integer> {

}
