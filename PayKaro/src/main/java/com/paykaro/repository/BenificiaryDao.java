package com.paykaro.repository;

import com.paykaro.model.Benificiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface BenificiaryDao extends JpaRepository<Benificiary, String>{
	Benificiary findByMobileNumber(String mobileNumber);
}


