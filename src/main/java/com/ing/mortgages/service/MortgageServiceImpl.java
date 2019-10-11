package com.ing.mortgages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgages.dto.MortgageViewResponseDTO;
import com.ing.mortgages.entity.Mortgage;
import com.ing.mortgages.exception.MortgagesDoesntExistException;
import com.ing.mortgages.repository.MortgageRepository;

@Service
public class MortgageServiceImpl implements MortgageService {
	

	@Autowired
	MortgageRepository mortgagerepository;

	@Override
	public List<MortgageViewResponseDTO> viewMortgages() {
		List<Mortgage> findAll = mortgagerepository.findAll();
		
		Optional<List<Mortgage>> optMortgages = Optional.of(findAll);
		
		if(!optMortgages.isPresent())
			throw new MortgagesDoesntExistException("mortgage doesnt exist");
		
		
		
		List<MortgageViewResponseDTO> newList = new ArrayList<>();
		
		findAll.forEach(mortgagees->{
			MortgageViewResponseDTO list = new MortgageViewResponseDTO();
			list.setPropertyName(mortgagees.getPropertyName());
			list.setPropertyValue(mortgagees.getPropertyValue());
			list.setTenure(mortgagees.getTenure());
			list.setTotalAmount(mortgagees.getTotalAmount());
			list.setEmi(mortgagees.getEmi());
			list.setOutstandingBalance(mortgagees.getOutstandingBalance());
			list.setCreatedDate(mortgagees.getCreatedDate());
			list.setUserId(mortgagees.getUser().getUserId());
			newList.add(list);
		});
		
		return newList;
		
	}
	}

