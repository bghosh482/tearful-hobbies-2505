package com.paykaro.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Benificiary {

	private Integer bid;
	private String name;
	private String mobileNo;
	
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

}
