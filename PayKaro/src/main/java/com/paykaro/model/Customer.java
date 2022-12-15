package com.paykaro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

//@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;
	private String name;
	private String mobileNumber;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Benificiary> benificiaries = new ArrayList<>();

}
