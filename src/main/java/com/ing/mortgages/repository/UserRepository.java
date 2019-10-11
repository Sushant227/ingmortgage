package com.ing.mortgages.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.mortgages.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<List<User>> findByEmailAndPassword(String email, String password);

	Optional<List<User>> findByUserId(Integer userId);

}
