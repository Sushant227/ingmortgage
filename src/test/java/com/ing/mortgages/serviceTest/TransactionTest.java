package com.ing.mortgages.serviceTest;



import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.PrintStream;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.mortgages.entity.Account;
import com.ing.mortgages.entity.Mortgage;
import com.ing.mortgages.entity.Transaction;
import com.ing.mortgages.entity.User;
import com.ing.mortgages.repository.AccountRepository;
import com.ing.mortgages.repository.MortgageRepository;
import com.ing.mortgages.repository.TransactionRepository;
import com.ing.mortgages.repository.UserRepository;
import com.ing.mortgages.service.TransactionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTest {

	
	@Autowired
	private TransactionService transactionService;

	@MockBean
	private TransactionRepository transactionRepository;
	
	


	@MockBean
	private UserRepository userRepository;
	
	@MockBean
	private MortgageRepository mortgageRepository;
	
	@MockBean
	private AccountRepository accountRepository;
	
	
	@Test
	public void cretaeTransaction()
	{
	User user= new User();
	Transaction transaction= new Transaction();
	Mortgage mortgage= new Mortgage();
	Account account= new Account();
	user.setUserId(1);
	user.setUserName("Shankar");
	user.setAddress("Bangalore");
	user.setEmail("shankar.sft93@gmail.com");
	user.setPhone(9952074514L);
	user.setPassword("welcome");
	account.setAccountId(1);
	account.setAccountNumber(1244444L);
	account.setBalance(2000000.0);
	account.setUser(user);
	mortgage.setMortgageId(1);
	mortgage.setCreatedDate(LocalDateTime.now());
	mortgage.setEmi(5000.0);
	mortgage.setLoanAmount(2000000);
	mortgage.setOutstandingBalance(15000000.0);
	mortgage.setPropertyAddress("Bangalore");
	mortgage.setPropertyName("House");
	mortgage.setPropertyValue(2500000);
	mortgage.setRateOfInterest(5);
	mortgage.setTenure(5);
	mortgage.setTotalAmount(2800000.0);
	mortgage.setUser(user);
	transaction.setAccount(account);
	transaction.setAccountNo(account.getAccountNumber());
	transaction.setAmountDeducted(mortgage.getEmi());
	transaction.setMortgageId(mortgage.getMortgageId());
	transaction.setOutStandingBalance(mortgage.getOutstandingBalance());
	transaction.settDate(LocalDateTime.now());
	transaction.setTransactionId(1);
	when(transactionRepository.save(transaction)).thenReturn(transaction);
	 assertEquals(transaction, transactionRepository.save(transaction));
	}
	
}
