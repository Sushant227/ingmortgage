package com.ing.mortgages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.mortgages.entity.User;




@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
