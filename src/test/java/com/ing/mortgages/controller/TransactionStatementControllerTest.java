package com.ing.mortgages.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ing.mortgages.controller.TransactionStatementController;
import com.ing.mortgages.dto.TransactionStatementDto;
import com.ing.mortgages.service.TransactionStatementServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionStatementControllerTest {
	
	
	
	@InjectMocks
	TransactionStatementController transactionController;
	
	@Mock
	TransactionStatementServiceImpl transactionService;
	

	@Test
	public void getAllBeneficiaryControllerTest()
	{
		List<TransactionStatementDto> statements= new ArrayList<TransactionStatementDto>();
		TransactionStatementDto state= new TransactionStatementDto();
		state.setAccountNo(123567L);
		state.setAmountDeducted(3000);
		state.setMortgageId(1);
		state.setOutStandingBalance(200000.0);
		state.settDate(LocalDateTime.now());
		state.setTransactionId(1);
		statements.add(state);
		 when(transactionService.accountTransactionStatements(123456)).thenReturn(statements);
		 assertEquals(1,transactionController.accountTransactionStatements(123456).getBody().size());
	}
	
	
	
}
