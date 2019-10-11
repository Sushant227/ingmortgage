package com.ing.mortgages.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgages.dto.MortgageViewResponseDTO;
import com.ing.mortgages.service.MortgageService;
/**
 * 
 * @author Sravya Uppu
 *
 */

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class MortgageController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MortgageController.class);

	@Autowired
	MortgageService mortgageservice;
	
	
	/**
	 * spring security and allowed only for admin
	 * No parameters
	 * @return List<MortgageViewResponseDTO> 
	 */
	@GetMapping("admin/mortgages")
	public List<MortgageViewResponseDTO> viewMortgages(){
		LOGGER.info("Enter into MortgageController::----viewMortgages()");
		return mortgageservice.viewMortgages();
	
	}
}
