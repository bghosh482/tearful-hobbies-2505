package com.paykaro.service;
import java.util.List;
import com.paykaro.model.Benificiary;
import com.paykaro.model.Customer;
public interface BenificiaryService {
	public Benificiary addBenificiary(Benificiary bd);
	public String deleteBenificiary(Benificiary bd);
	public Benificiary viewBenificiary(String mobileNumber);
	public List<Benificiary> viewAllBenificiary();
	
	
}
