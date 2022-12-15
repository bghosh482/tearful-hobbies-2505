package com.paykaro.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paykaro.dto.TransactionDTO;
import com.paykaro.model.Transaction;
import com.paykaro.model.Wallet;
import com.paykaro.service.TransactionService;

 

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/transaction")
	public ResponseEntity<TransactionDTO> addTranscation( @io.swagger.v3.oas.annotations.parameters.RequestBody TransactionDTO tr) {
		
		return new ResponseEntity<TransactionDTO>(transactionService.addTranscation(tr), HttpStatus.ACCEPTED);
	}
	
	

	@GetMapping("/transactions{id}")
	public ResponseEntity<List<Transaction>> viewTransactionByWallet(@PathVariable("id")  Integer wallet_id) {

		return new ResponseEntity<>(transactionService.viewTransactionByWallet(wallet_id), HttpStatus.OK);
	}
 
	@GetMapping("/transaction")
	public ResponseEntity<List<Transaction>> viewTransactionByDate(@RequestParam LocalDate from,
			@RequestParam LocalDate to) {

		return new ResponseEntity<>(transactionService.viewTransactionByDate(from, to), HttpStatus.OK);
	}

	@GetMapping("/transaction{type}")
	public ResponseEntity<List<Transaction>> viewALLTransaction(@PathVariable("type") String type) {

		return new ResponseEntity<>(transactionService.viewALLTransaction(type), HttpStatus.OK);
	}

}
