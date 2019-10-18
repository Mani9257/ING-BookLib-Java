package com.hcl.booklib.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.booklib.dto.RegistrationResponseDto;
import com.hcl.booklib.dto.UserDetailsDto;
import com.hcl.booklib.entity.User;
import com.hcl.booklib.exception.UserDoesNotExistException;
import com.hcl.booklib.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;

	RegistrationResponseDto registrationResponseDto = new RegistrationResponseDto();
	UserDetailsDto userDetailsDto = new UserDetailsDto();
	UserDetailsDto userDetailsDto2 = new UserDetailsDto();
	User user = new User();

	@Before
	public void setUp() {

		registrationResponseDto.setStatusCode(201);
		registrationResponseDto.setStatusMessage("SUCCESS");
		registrationResponseDto.setUserId(1);

		userDetailsDto.setUserEmail("suchita@gmail.com");
		userDetailsDto.setUserName("Suchita");

		user.setUserId(1);
		user.setUserName("Suchita");
		user.setUserEmail("suchita@gmail.com");

	}

	@Test
	public void testRegistration() {

	

		Assert.assertEquals("SUCCESS", registrationResponseDto.getStatusMessage());

	}

	@Test(expected = UserDoesNotExistException.class)
	public void testRegistrationInvalid() throws UserDoesNotExistException {

		userServiceImpl.registration(null);

		Assert.assertEquals(null, userDetailsDto2.getUserEmail());

	}

}
