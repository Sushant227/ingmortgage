package com.ing.mortgages.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgages.dto.TransactionStatementDto;
import com.ing.mortgages.service.TransactionStatementService;

@RequestMapping("/accounts")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
/**
 * 
 * @author Pradeep AJ
 *
 */
public class TransactionStatementController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionStatementController.class);
	
	
	@Autowired
	private TransactionStatementService transactionStatementService;
	/**
	 * 
	 * @param userId-NotNull
	 * @return List<TransactionStatementDto
	 */
	
	@GetMapping("/{accountNumber}")
	public ResponseEntity<List<TransactionStatementDto>> accountTransactionStatements(@PathVariable Integer accountNumber){
		LOGGER.info("Enter into TransactionStatementController::-----accountTransactionStatements()");
     return new ResponseEntity<>(transactionStatementService.accountTransactionStatements(accountNumber), HttpStatus.OK); 
	}

}
