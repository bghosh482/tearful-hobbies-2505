package com.paykaro.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Benificiary {
@Id
	private Integer bid;
	private String name;
	private String mobileNo;

}
