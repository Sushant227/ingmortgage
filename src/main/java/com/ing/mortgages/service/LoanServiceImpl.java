package com.ing.mortgages.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgages.constants.Constants;
import com.ing.mortgages.dto.ApplyResponseDTO;
import com.ing.mortgages.dto.ListOfLoansDTO;
import com.ing.mortgages.dto.LoanRequestDTO;
import com.ing.mortgages.entity.Loan;
import com.ing.mortgages.entity.Mortgage;
import com.ing.mortgages.entity.User;
import com.ing.mortgages.exception.LoansListEmpty;
import com.ing.mortgages.exception.NotEligibleForTakingLoan;
import com.ing.mortgages.repository.LoanRepository;
import com.ing.mortgages.repository.MortgageRepository;
import com.ing.mortgages.repository.UserRepository;


/**
 * 
 * @author Sravya Uppu
 *
 */
@Service
public class LoanServiceImpl implements LoanService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MortgageServiceImpl.class);
	
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	LoanRepository loanrepository;
	
	@Autowired
	MortgageRepository mortgageRepository;
	
	

	/**
	 * 
	 * @param annualIncome,propertyValue
	 * @return List<ListOfLoansDTO>
	 */
	@Override
	public List<ListOfLoansDTO> viewLoans(Integer annualIncome,Integer propertyValue) {
		
		LOGGER.info("viewLoans:: {}=,annualIncome,propertyValue");
		
		Integer income = 3*annualIncome;
		
		Integer eligbleAmount = (propertyValue * 80)/100;
		
		if(annualIncome<100000) 
			throw new NotEligibleForTakingLoan("salary should be greater than 500000 for applying loan");
		
		Optional<List<Loan>> loansList = loanrepository.getLoanByLoanAmount(eligbleAmount,income);
		
		if(!loansList.isPresent())
			throw new LoansListEmpty("loans are empty");
		
		List<Loan> loans= loansList.get();
		
		List<ListOfLoansDTO> newList = new ArrayList<>();
		
		loans.forEach(loan->{
			ListOfLoansDTO list = new ListOfLoansDTO();
			list.setLoanId(loan.getLoanId());
			list.setLoanAmount(loan.getLoanAmount());
			list.setRateOfInterest(loan.getRateOfInterest());
			list.setTenure(loan.getTenure());
			list.setEmi(loan.getEMI());
			newList.add(list);
		});
		
		return newList;

		}
	
	
	/**
	 * 
	 * @RequestBody LoanRequestDTO
	 * @return ApplyResponseDTO
	 */
	 @Override
	 public ApplyResponseDTO apply(LoanRequestDTO loanRequest) {
		 
			LOGGER.info("apply:: {}=",loanRequest);
		 
		 Optional<List<User>> userDetail = userrepository.findByUserId(loanRequest.getUserId());
		 
		 Optional<List<Loan>> loanDetail = loanrepository.findByLoanId(loanRequest.getLoanId());
		 
		 if(!loanDetail.isPresent())
				throw new LoansListEmpty("loans are empty");
		 
		 if(!userDetail.isPresent())
				throw new LoansListEmpty("users are empty");
		 
		 Integer loanAmt = loanDetail.get().get(0).getLoanAmount();
		 Integer roi = loanDetail.get().get(0).getRateOfInterest();
		 
		 Double totalAmount =  (double) loanAmt + ((roi*loanAmt)/100.00);
		 
		 Double outstandingBalance = totalAmount;
		 
		 Mortgage mortgage = new Mortgage();
		 mortgage.setCreatedDate(LocalDateTime.now());
		 mortgage.setEmi(loanDetail.get().get(0).getEMI());
		 mortgage.setLoanAmount(loanDetail.get().get(0).getLoanAmount());
		 mortgage.setOutstandingBalance(outstandingBalance);
		 mortgage.setPropertyAddress(loanRequest.getPropertyAddress());
		 mortgage.setPropertyName(loanRequest.getPropertyName());
		 mortgage.setPropertyValue(loanRequest.getPropertyValue());
		 mortgage.setRateOfInterest(loanDetail.get().get(0).getRateOfInterest());
		 mortgage.setTenure(loanDetail.get().get(0).getTenure());
		 mortgage.setTotalAmount(totalAmount);
		 mortgage.setUser(userDetail.get().get(0));	 
		 
		 mortgageRepository.save(mortgage);
		 
		 ApplyResponseDTO apply = new ApplyResponseDTO();
		 apply.setStatusCode(Constants.APPLY_SUCCESS);
		 apply.setStatusMessage(Constants.SUCCESS_STATUS_CODE);
		 
		 return apply;
		 
	 	}
}
