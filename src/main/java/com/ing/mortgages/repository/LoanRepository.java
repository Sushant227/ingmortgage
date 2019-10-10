package com.ing.mortgages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.mortgages.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{
	
}