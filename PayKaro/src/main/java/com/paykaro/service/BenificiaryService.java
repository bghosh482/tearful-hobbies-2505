package com.paykaro.service;
import java.util.List;
import com.paykaro.model.Benificiary;
import com.paykaro.model.Customer;
public interface BenificiaryService {
	public Benificiary addBeneficiary(Benificiary bd);
	public Benificiary deleteBeneficiary(Benificiary bd);
	public Benificiary viewBeneficiary(String mobNo);
	public List<Benificiary> viewAllBenificiary(Customer customer);
	
	
}
