package com.ing.mortgages.service;

import java.util.List;

import com.ing.mortgages.dto.TransactionStatementDto;

public interface TransactionStatementService {

	List<TransactionStatementDto> accountTransactionStatements(Integer accountNumber);

}
