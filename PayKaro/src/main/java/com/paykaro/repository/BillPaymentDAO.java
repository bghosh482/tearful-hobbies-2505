package com.paykaro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paykaro.model.BillPayment;
import com.paykaro.model.Wallet;

@Repository
public interface BillPaymentDAO extends JpaRepository<BillPayment, Integer> {

	public List<BillPayment> findByWallet(Wallet wallet);

}
