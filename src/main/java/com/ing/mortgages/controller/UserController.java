package com.ing.mortgages.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgages.dto.CustomerRequestDTO;
import com.ing.mortgages.dto.LoginResponseDTO;
import com.ing.mortgages.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping(value="/login")
	public LoginResponseDTO getCustomerByNameAndPassword(@RequestBody CustomerRequestDTO customerDto){
				
		String email= customerDto.getEmail();
		String password= customerDto.getPassword();
		LoginResponseDTO checkCustomer = userservice.checkCustomer(email,password);
		
		return checkCustomer;

	}
	
}

