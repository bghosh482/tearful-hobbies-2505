package com.paykaro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paykaro.model.Account;
import com.paykaro.model.Wallet;
import com.paykaro.service.AccountServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/bank")
public class AccountController {
    
	@Autowired
	private AccountServiceImpl crud;

	@PostMapping("/addAccount/{wallid}")
      public ResponseEntity<Wallet> addBankAccount(@RequestBody Account bankAccount,@PathVariable Integer wallid){
	     	Wallet wall = crud.addAccount(bankAccount,wallid);
         	return new ResponseEntity<>(wall,HttpStatus.ACCEPTED); 
       }
	
	@DeleteMapping("/removeBankAccount")
	public ResponseEntity<Wallet> removeBankAccount(@RequestBody Account bankAccount ){
		
		return new ResponseEntity<>(crud.removeAccount(bankAccount),HttpStatus.OK);
	}
	
	@GetMapping("/viewAccount/{accId}/{wallid}")
	public ResponseEntity<Account> viewAccount(@PathVariable Integer accId,@PathVariable Integer wallid){
		return new ResponseEntity<>(crud.viewAccount(wallid,accId),HttpStatus.OK);
	}
	
	@GetMapping("/viewAllAccount/{wallId}")
	public ResponseEntity<List<Account>> viewAllBankAccount(@PathVariable Integer wallId){
		return new ResponseEntity<>(crud.viewAllAccounts(wallId),HttpStatus.OK);
	}
}
