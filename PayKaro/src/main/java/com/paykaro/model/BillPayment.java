package com.paykaro.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class BillPayment {
	@Id
	private Integer billId;
	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;

	private String billType;
	private Double amount;
	private LocalDate paymentDate;

}
