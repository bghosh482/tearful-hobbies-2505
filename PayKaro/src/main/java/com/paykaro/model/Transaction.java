package com.paykaro.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Data;

@Entity
@JsonIgnoreType
public class Transaction {

	@Id
	private Integer transactionId;
	private String transactionType;
	private LocalDate transactionDate;
	private Double amount;
	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Transaction() {
		super();
		
	}

	public Transaction(Integer transactionId, String transactionType, LocalDate transactionDate, Double amount,
			String description, Wallet wallet) {

		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionDate = LocalDate.now();
		this.amount = amount;
		this.description = description;
		this.wallet = wallet;
	}

}
