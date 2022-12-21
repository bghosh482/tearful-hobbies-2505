package com.paykaro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;
	@NotBlank
	@NotNull
	@NotEmpty
	private String name;

	@NotBlank
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String mobileNo;
	@NotBlank
	@NotNull
	@NotEmpty
	private String password;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cusid")
	private Wallet wallet;

}
