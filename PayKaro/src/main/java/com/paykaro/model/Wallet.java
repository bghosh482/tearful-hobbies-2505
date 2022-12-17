package com.paykaro.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data

public class Wallet {
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public List<Account> getAccouonts() {
		return accouonts;
	}
	public void setAccouonts(List<Account> accouonts) {
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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer wid;
	private BigDecimal balance;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Account> accouonts = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<Transaction> transactions = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<BillPayment> billPayments = new ArrayList<>();

}
