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

@Entity
@Data
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer wid;
	private BigDecimal balance;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Accouont> accouonts = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<Transaction> transactions = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<BillPayment> billPayments = new ArrayList<>();

}
