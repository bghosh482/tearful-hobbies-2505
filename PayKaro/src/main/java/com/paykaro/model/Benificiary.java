package com.paykaro.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Benificiary {
	@Id
	@GeneratedValue
	private Integer benificiaryId;
	private String name;
	private String mobileNumber;
	
	public Benificiary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getbenificiaryId() {
		return benificiaryId;
	}
	public void setbenificiaryId(Integer benificiaryId) {
		this.benificiaryId = benificiaryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Benificiary [benificiaryId=" + benificiaryId + ", name=" + name + ", mobileNumber=" + mobileNumber + "]";
	}
	

}
