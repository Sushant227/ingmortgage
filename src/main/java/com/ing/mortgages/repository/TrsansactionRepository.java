package com.ing.mortgages.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.mortgages.entity.Transaction;
@Repository
public interface TrsansactionRepository extends JpaRepository<Transaction, Integer> {

	@Query(value="select *  from transaction t where t.account_number=?1",nativeQuery = true)
	Optional<List<Transaction>> findStatementsAccountNumber(Integer accountNumber);


}
