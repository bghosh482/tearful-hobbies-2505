package com.paykaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paykaro.model.BillPayment;

@Repository
public interface BillPaymentDAO extends JpaRepository<BillPayment, Integer> {

}
