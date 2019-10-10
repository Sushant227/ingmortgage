package com.ing.mortgages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.mortgages.entity.Transaction;

@Repository
public interface TransactionRepository extends  JpaRepository<Transaction,Integer>{

}
