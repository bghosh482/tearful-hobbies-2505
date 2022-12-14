package com.paykaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paykaro.model.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

}
