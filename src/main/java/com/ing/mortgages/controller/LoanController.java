package com.ing.mortgages.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgages.dto.ApplyResponseDTO;
import com.ing.mortgages.dto.ListOfLoansDTO;
import com.ing.mortgages.dto.LoanRequestDTO;
import com.ing.mortgages.service.LoanService;
/**
 * 
 * @author Sravya Uppu
 *
 */

@RestController
@RequestMapping("loans")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins= {"*","*/"})
public class LoanController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);
	
	@Autowired
	LoanService loanservice;
	
	/**
	 * 
	 * @Param annualIncome propertyValue
	 * @return List<ListOfLoansDTO> 
	 */
	@GetMapping("/")
	public List<ListOfLoansDTO> viewLoans(@RequestParam("annualIncome") Integer annualIncome, @RequestParam("propertyValue") Integer propertyValue) {
		LOGGER.info("Enter into LoanController::----viewLoans()");
		return loanservice.viewLoans(annualIncome,propertyValue);
		
	}
	
	
	/**
	 * 
	 * @param LoanRequestDTO
	 * @return ApplyResponseDTO 
	 */
	@PostMapping("/")
	public ApplyResponseDTO applyLoan(@RequestBody LoanRequestDTO loanRequest) {
		LOGGER.info("Enter into LoanController::----applyLoan()");

		return loanservice.apply(loanRequest);
	}
}
