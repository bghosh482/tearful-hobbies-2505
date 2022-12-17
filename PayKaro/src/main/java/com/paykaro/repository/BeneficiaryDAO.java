package com.paykaro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paykaro.model.Beneficiary;

@Repository
public interface BeneficiaryDAO extends JpaRepository<Beneficiary, Integer> {
	List<Beneficiary> findByMobileNo(String mobileNo);

}
