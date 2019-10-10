package com.ing.mortgages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.mortgages.entity.Mortgage;

@Repository
public interface MortgageRepository extends JpaRepository<Mortgage,Integer> {
	
	@Query(value="select * from mortgage  where user_id=?", nativeQuery=true)
	public Mortgage getUserId(Integer id);

	
}
