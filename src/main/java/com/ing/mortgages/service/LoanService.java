package com.ing.mortgages.service;

import java.util.List;

import com.ing.mortgages.dto.ApplyResponseDTO;
import com.ing.mortgages.dto.ListOfLoansDTO;
import com.ing.mortgages.dto.LoanRequestDTO;

public interface LoanService {

	List<ListOfLoansDTO> viewLoans(Integer propertyValue,Integer salary);

	ApplyResponseDTO apply(LoanRequestDTO loanRequest);
	
}
