package com.paykaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paykaro.model.Wallet;

@Repository
public interface WalletDAO extends JpaRepository<Wallet, Integer> {

}
