package com.paykaro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

	private Double amount;
	private String description;
	private String transactionType;
	private Integer walletid;

}
