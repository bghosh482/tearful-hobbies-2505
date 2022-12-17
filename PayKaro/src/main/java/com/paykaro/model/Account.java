package com.paykaro.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accId;
	private String accountNo;
	private String ifscCode;
	private String bankName;
	private Double balance;
	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
}
