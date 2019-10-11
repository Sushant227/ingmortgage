package com.ing.mortgages.service;

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

import com.ing.mortgages.dto.LoginResponseDTO;
import com.ing.mortgages.entity.User;
import com.ing.mortgages.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	/**
	 * 
	 * @author Sravya Uppu
	 *
	 */

	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;

	
	@Test
	public void testCheckCustomer() {		
		
		User user = new User();
		user.setUserId(1);
		user.setUserName("sravya");
		user.setPhone(90077);
		user.setEmail("e@g.com");
		user.setAddress("hyd");
		user.setPassword("abc");
		
		List<User> newUser = new ArrayList<>();
		newUser.add(user);
		Optional<List<User>> users = Optional.of(newUser);
		
		Mockito.when(userRepository.findByEmailAndPassword(Mockito.any(),Mockito.any())).thenReturn(users);
		
		LoginResponseDTO checkCustomer = userServiceImpl.checkCustomer("e@g.com","abc");
		
		Assert.assertNotNull(checkCustomer);
		Assert.assertEquals("user succcessfully logged in", checkCustomer.getStatusMessage());
	}
	
}
