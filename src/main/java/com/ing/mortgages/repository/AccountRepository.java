package com.ing.mortgages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.mortgages.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
	
	@Query(value="select * from account  where user_id=?",nativeQuery=true)
	public Account findByUserId(Integer id);

}
