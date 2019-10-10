package com.ing.mortgages.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.mortgages.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="SELECT DISTINCT user_id FROM User",nativeQuery=true)
	public List<Integer> getDistinctUserId();

}
