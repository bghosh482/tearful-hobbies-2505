package com.paykaro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
	
	private Integer amount;
	private String description;
	private String transactionType;
	private Integer walletid;
	

}
