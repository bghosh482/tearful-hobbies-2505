package com.paykaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paykaro.model.Account;

public interface AccountDAO extends JpaRepository<Account, Integer> {
	

}
