package com.paykaro.service;

import com.paykaro.exception.BeneficiaryException;
import com.paykaro.exception.CustomerException;
import com.paykaro.model.Beneficiary;

public interface BeneficiaryService {
	public Beneficiary addBeneficiary(Beneficiary beneficiary, String key)
			throws BeneficiaryException, CustomerException;

	public Beneficiary deleteBeneficiary(Beneficiary beneficiary, String key) throws CustomerException;
}
