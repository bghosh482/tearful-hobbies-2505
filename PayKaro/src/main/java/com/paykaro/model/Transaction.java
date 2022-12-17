package com.paykaro.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	private String transactionType;
	@CreatedDate
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate transactionDate;
	private Double amount;
	private String description;
	@ManyToOne
	@JoinColumn(name = "walletId")
	private Wallet wallet;

	public Transaction() {

	}

}
