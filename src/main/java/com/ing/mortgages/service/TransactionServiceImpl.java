package com.ing.mortgages.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.ing.mortgages.entity.Account;
import com.ing.mortgages.entity.Mortgage;
import com.ing.mortgages.entity.Transaction;
import com.ing.mortgages.entity.User;
import com.ing.mortgages.exception.PleaseCheckYourBalance;
import com.ing.mortgages.repository.AccountRepository;
import com.ing.mortgages.repository.MortgageRepository;
import com.ing.mortgages.repository.TrsansactionRepository;
import com.ing.mortgages.repository.UserRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	TrsansactionRepository transactionRepository;
	
	@Autowired
	MortgageRepository mortgageRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Scheduled(cron="*/120 * * * * * ")
	public void createTransaction() {
		
		List<Integer> users = userRepository.getDistinctUserId();
		users.stream().forEach(id -> {
			
			  User user=userRepository.findById(id).get(); 
			    Account account= new Account();
			   
			    account=  accountRepository.findByUserId(id);
			    Mortgage mortgage= new Mortgage();
			    mortgage= mortgageRepository.getUserId(user.getUserId());
			    if(account.getBalance()>=mortgage.getEmi())
			    { mortgage.setOutstandingBalance(mortgage.getOutstandingBalance()-mortgage.getEmi());
			    mortgage.setCreatedDate(LocalDateTime.now());
			    mortgageRepository.save(mortgage);	
			    account.setBalance(account.getBalance()-mortgage.getEmi());
			    accountRepository.save(account);
			    Transaction transact= new Transaction();
			    transact.setAccountNo(account.getAccountNumber());
			    transact.setAmountDeducted(mortgage.getEmi());
			    transact.setOutStandingBalance( mortgage.getOutstandingBalance());
			    transact.setMortgageId(mortgage.getMortgageId());
			    transact.settDate(LocalDateTime.now());
			    transact.setAccount(account);
			    transactionRepository.save(transact);
			    }
			    else
			    {
			    	throw new PleaseCheckYourBalance("Please Check Your Account Balance");
			    }
		});
  
    }
	}

