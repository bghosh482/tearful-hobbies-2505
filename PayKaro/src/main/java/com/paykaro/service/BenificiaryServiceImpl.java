package com.paykaro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.paykaro.model.Benificiary;
import com.paykaro.model.Customer;
import com.paykaro.repository.BenificiaryDao;

@Service

public class BenificiaryServiceImpl  implements BenificiaryService{
	@Autowired
	BenificiaryDao repository;
	
	@Override
	public Benificiary addBenificiary(Benificiary bd) {
		// TODO Auto-generated method stub
		repository.save(bd);
		return bd;
	}

	@Override
	public List<Benificiary> viewAllBenificiary() {
		// TODO Auto-generated method stub
		List<Benificiary> l=repository.findAll();
		return l;
	}

	@Override
	public String deleteBenificiary(Benificiary bd) {
		// TODO Auto-generated method stub
		 repository.delete(bd);
		return "Deleted";
	}

	@Override
	public Benificiary viewBenificiary(String mobileNumber) {
		// TODO Auto-generated method stub
		Benificiary bd=repository.findByMobileNumber(mobileNumber);
		return bd;
	}

}
