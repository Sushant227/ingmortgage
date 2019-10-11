package com.ing.mortgages.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgages.dto.CustomerRequestDTO;
import com.ing.mortgages.dto.LoginResponseDTO;
import com.ing.mortgages.service.UserService;
/**
 * 
 * @author Sravya Uppu
 *
 */
@RestController
@RequestMapping("/login")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	UserService userservice;
	
	/**
	 * 
	 * @RequestBody CustomerRequestDTO
	 * @return LoginResponseDTO 
	 */
	@PostMapping(value="/")
	public LoginResponseDTO getCustomerByNameAndPassword(@RequestBody CustomerRequestDTO customerDto){
		LOGGER.info("Enter into UserController::----getCustomerByNameAndPassword()");
	
		String email= customerDto.getEmail();
		String password= customerDto.getPassword();
		LoginResponseDTO checkCustomer = userservice.checkCustomer(email,password);
		
		return checkCustomer;

	}
	
}

