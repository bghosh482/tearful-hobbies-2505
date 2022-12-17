package com.paykaro.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class BillPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;

	private String billType;
	private Double amount;
	private LocalDate paymentDate;
	@ManyToOne
	@JoinColumn(name = "walletId")
	private Wallet wallet;

	public BillPayment() {
		this.paymentDate = LocalDate.now();
	}

}
