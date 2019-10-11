package com.ing.mortgages.service;

import com.ing.mortgages.dto.LoginResponseDTO;

public interface UserService {

	LoginResponseDTO checkCustomer(String email, String password);
	
}
