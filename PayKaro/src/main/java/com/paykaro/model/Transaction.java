package com.paykaro.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

//@Entity
@Data
public class Transaction {
	private Integer transactionId;
	private String transactionType;
	private LocalDate transactionDate;

	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;

	private Double amount;
	private String description;

}
