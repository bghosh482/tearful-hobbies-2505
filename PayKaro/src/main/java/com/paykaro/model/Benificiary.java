package com.paykaro.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Benificiary {

	private Integer bid;
	private String name;
	private String mobileNo;

}
