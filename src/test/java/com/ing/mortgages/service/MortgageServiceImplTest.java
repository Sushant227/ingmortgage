package com.ing.mortgages.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.mortgages.dto.MortgageViewResponseDTO;
import com.ing.mortgages.entity.Mortgage;
import com.ing.mortgages.entity.User;
import com.ing.mortgages.repository.MortgageRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MortgageServiceImplTest {
	
	/**
	 * 
	 * @author Sravya Uppu
	 *
	 */

	@Mock
	MortgageRepository mortgagerepository;
	
	@InjectMocks
	MortgageServiceImpl mortgageServiceImpl;

	
	@Test
	public void testviewMortgages() {
		
		
		User user = new User();
		user.setUserId(1);
		user.setUserName("sravya");
		user.setPhone(90077);
		user.setEmail("e@g.com");
		user.setAddress("hyd");
		
		
		Mortgage mortgage = new Mortgage();
		mortgage.setMortgageId(1);
		mortgage.setCreatedDate(LocalDateTime.now());
		mortgage.setEmi(5000.0);
		mortgage.setLoanAmount(2000000);
		mortgage.setOutstandingBalance(15000000.0);
		mortgage.setPropertyAddress("Bangalore");
		mortgage.setPropertyName("House");
		mortgage.setPropertyValue(2500000);
		mortgage.setRateOfInterest(5);
		mortgage.setTenure(5);
		mortgage.setTotalAmount(2800000.0);
		mortgage.setUser(user);
		
		List<Mortgage> mortgages = new ArrayList<>();
		mortgages.add(mortgage);
				
		Mockito.when(mortgagerepository.findAll()).thenReturn(mortgages);
		
		List<MortgageViewResponseDTO> viewMortgages = mortgageServiceImpl.viewMortgages();
		
		
		Assert.assertNotNull(viewMortgages);
		Assert.assertEquals(1,viewMortgages.size());
	}
	
}
