package com.paykaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paykaro.model.Wallet;

public interface WalletDao extends JpaRepository<Wallet, Integer> {
	

}
