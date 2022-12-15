package com.paykaro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.paykaro.service.WalletService;


@RestController
public class WalletController {

	@Autowired
	private WalletService wService;
	
	
	

}
