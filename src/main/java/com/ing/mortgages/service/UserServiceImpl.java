package com.ing.mortgages.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgages.constants.Constants;
import com.ing.mortgages.dto.LoginResponseDTO;
import com.ing.mortgages.entity.User;
import com.ing.mortgages.exception.InvalidUsernameOrPasswordException;
import com.ing.mortgages.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	UserRepository userrepository;

	@Override
	public LoginResponseDTO checkCustomer(String email, String password) {
		
		
		
		Optional<List<User>> user = userrepository.findByEmailAndPassword(email,password);	
		
		if(!user.isPresent())
			throw new InvalidUsernameOrPasswordException("invalid username or password");
		LoginResponseDTO loginResponse = new LoginResponseDTO();


		if(user.get().get(0).getEmail().equals(email)&& user.get().get(0).getPassword().equals(password)) {
			
			loginResponse.setCustomerId(user.get().get(0).getUserId());
			loginResponse.setStatusCode(Constants.SUCCESS_STATUS_CODE);
			loginResponse.setStatusMessage(Constants.SUCCESS_LOGGED_MESSAGE);
		}
			return loginResponse;
	
	}

}
