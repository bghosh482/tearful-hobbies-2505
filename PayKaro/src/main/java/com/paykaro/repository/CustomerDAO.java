package com.paykaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paykaro.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

}
