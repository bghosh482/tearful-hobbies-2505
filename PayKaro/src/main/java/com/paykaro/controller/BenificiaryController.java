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
import org.springframework.web.bind.annotation.RestController;

import com.paykaro.model.Benificiary;
import com.paykaro.service.BenificiaryServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping(path="/api")
public class BenificiaryController {
	@Autowired
	BenificiaryServiceImpl benificiary;
	
	@PostMapping("/addBenificiary")
	public ResponseEntity<Benificiary> addBenificiary(@RequestBody Benificiary bd) {
		Benificiary bd1 =benificiary.addBenificiary(bd);
		ResponseEntity re=new ResponseEntity<Benificiary>(bd1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping("/deleteBenificiary")
	public ResponseEntity<String> deleteBenificiary(@RequestBody Benificiary bd)
	{
		benificiary.deleteBenificiary(bd);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/viewBenificiary/{mobileNumber}")
	public ResponseEntity <Benificiary> viewBenificiary(@PathVariable String mobileNumber)
	{
		Benificiary bd1=benificiary.viewBenificiary(mobileNumber);
		ResponseEntity re=new ResponseEntity<Benificiary>(bd1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/viewAllBenificiary")
	public ResponseEntity<List< Benificiary>> viewAllBenificiary()
	{
		List< Benificiary> l=benificiary.viewAllBenificiary();
		ResponseEntity re=new ResponseEntity<List< Benificiary>>(l,HttpStatus.OK);
		return re;
	}
}
