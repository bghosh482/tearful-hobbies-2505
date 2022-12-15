package com.paykaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paykaro.model.Account;

@Repository
public interface AccountDAO extends JpaRepository<Account, Integer> {

}
