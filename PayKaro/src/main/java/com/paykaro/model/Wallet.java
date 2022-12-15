package com.paykaro.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Data;

@Entity
@JsonIgnoreType
public class Wallet {
	
	@Id 
	private Integer wid;
	private double balance;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL , mappedBy="wallet")
	private List<Transaction> transactions = new ArrayList<>();
	
	
	
	
	
	
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Accouont> accouonts = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<BillPayment> billPayments = new ArrayList<>();

	public Wallet() {
		super();
	}

	public Wallet(Integer wid, double balance, List<Accouont> accouonts, List<Transaction> transactions,
			List<BillPayment> billPayments) {
		super();
		this.wid = wid;
		this.balance = balance;
		this.accouonts = accouonts;
		this.transactions = transactions;
		this.billPayments = billPayments;
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Accouont> getAccouonts() {
		return accouonts;
	}

	public void setAccouonts(List<Accouont> accouonts) {
		this.accouonts = accouonts;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<BillPayment> getBillPayments() {
		return billPayments;
	}

	public void setBillPayments(List<BillPayment> billPayments) {
		this.billPayments = billPayments;
	}

}
