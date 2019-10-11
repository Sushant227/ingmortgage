package com.ing.mortgages.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.mortgages.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{
	
	@Query(value="select * from loan where loan_amount<=:eligibleAmount and loan_amount<=:income",nativeQuery=true)
	public Optional<List<Loan>> getLoanByLoanAmount(@Param("eligibleAmount") Integer eligibleAmount,@Param("income") Integer income);

	
	public Optional<List<Loan>> findByLoanId(Integer loanId);
	
}