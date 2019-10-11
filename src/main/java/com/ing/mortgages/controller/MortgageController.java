package com.ing.mortgages.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgages.dto.MortgageViewResponseDTO;
import com.ing.mortgages.service.MortgageService;


@RestController
public class MortgageController {
	
	@Autowired
	MortgageService mortgageservice;
	
	@GetMapping("admin/mortgages")
	public List<MortgageViewResponseDTO> viewMortgages(){
		
		return mortgageservice.viewMortgages();
	
	}
}
