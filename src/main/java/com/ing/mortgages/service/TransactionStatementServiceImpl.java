package com.ing.mortgages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgages.dto.TransactionStatementDto;
import com.ing.mortgages.entity.Transaction;
import com.ing.mortgages.repository.TrsansactionRepository;

/**
 * 
 * @author Pradeep AJ
 *
 */

@Service
public class TransactionStatementServiceImpl implements TransactionStatementService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionStatementServiceImpl.class);
	@Autowired
	private TrsansactionRepository trsansactionRepository;

	/**
	 * 
	 * @param userId-NotNull
	 * @return List<TransactionStatementDto>
	 */

	@Override
	public List<TransactionStatementDto> accountTransactionStatements(Integer accountNumber) {
		LOGGER.info("accountTransactionStatements()");
		Optional<List<Transaction>> transactions = trsansactionRepository.findStatementsAccountNumber(accountNumber);
		List<TransactionStatementDto> result = new ArrayList<>();
		if (transactions.isPresent()) {

			List<Transaction> tra = transactions.get();
			tra.forEach(trans -> {
				LOGGER.info("transa Id::-----{}=",trans.getAccountNo());
				TransactionStatementDto td = new TransactionStatementDto();
				BeanUtils.copyProperties(trans, td);
				result.add(td);

			});

		}
		return result;
	}

}
