package com.ing.mortgages.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.mortgages.dto.MortgageViewResponseDTO;
import com.ing.mortgages.entity.Mortgage;
import com.ing.mortgages.exception.MortgagesDoesntExistException;
import com.ing.mortgages.repository.MortgageRepository;


/**
 * 
 * @author Sravya Uppu
 *
 */

@Service
public class MortgageServiceImpl implements MortgageService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MortgageServiceImpl.class);

	@Autowired
	MortgageRepository mortgagerepository;
	
	
	/**
	 * 
	 * @param no params
	 * @return List<MortgageViewResponseDTO>
	 */
	@Override
	public List<MortgageViewResponseDTO> viewMortgages() {
		
		LOGGER.info("viewMortgages:: {}");

		List<Mortgage> findAll = mortgagerepository.findAll();
		
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

