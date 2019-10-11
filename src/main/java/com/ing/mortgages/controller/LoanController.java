package com.ing.mortgages.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgages.dto.ApplyResponseDTO;
import com.ing.mortgages.dto.ListOfLoansDTO;
import com.ing.mortgages.dto.LoanRequestDTO;
import com.ing.mortgages.service.LoanService;


@RestController
@CrossOrigin(allowedHeaders = {"*","*/"}, origins= {"*","*/"})
public class LoanController {
	
	@Autowired
	LoanService loanservice;
	
	@GetMapping("/loans")
	public List<ListOfLoansDTO> viewLoans(@RequestParam("propertyValue") Integer propertyValue,@RequestParam("salary") Integer salary) {
			
		return loanservice.viewLoans(propertyValue,salary);
		
	}
	
	@PostMapping("/loans")
	public ApplyResponseDTO applyLoan(@RequestBody LoanRequestDTO loanRequest) {
		return loanservice.apply(loanRequest);
	}
}
