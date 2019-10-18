package com.hcl.booklib.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.booklib.dto.LoginResponseDto;
import com.hcl.booklib.dto.UserLoginDto;
import com.hcl.booklib.entity.User;
import com.hcl.booklib.exception.UserDoesNotExistException;
import com.hcl.booklib.repository.UserRepository;

@RunWith(SpringRunner.class)
public class LoginServiceTest {

	@InjectMocks
	LoginServiceImpl LoginServiceImpl;

	@Mock
	UserRepository userRepository;
	
	LoginResponseDto loginResponseDto = new LoginResponseDto();
	User user = new User();
	User user2 = new User();

	UserLoginDto loginDto = new UserLoginDto();
	UserLoginDto loginDto2 = new UserLoginDto();

	@Before
	public void setUp() {
		

		
		loginResponseDto.setMessage("Successful");
		loginResponseDto.setStatusCode(200);
		loginResponseDto.setUserId(1);

		
		
		user.setPassword("Suchita");
		user.setUserId(1);
		user.setUserName("Suchita");

		loginDto.setPassword("Suchita");
		loginDto.setUserName("Suchita");

	}

	@Test
	public void login() throws UserDoesNotExistException {


		Mockito.when(userRepository.findByUserNameAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(user);
		LoginResponseDto actualValue = LoginServiceImpl.loginUser(loginDto);
		Assert.assertEquals("Successful", actualValue.getMessage());

	}
	
	@Test(expected = UserDoesNotExistException.class)
	public void loginInvalid() throws UserDoesNotExistException {


		Mockito.when(userRepository.findByUserNameAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(user2);
		LoginResponseDto actualValue = LoginServiceImpl.loginUser(loginDto2);
		Assert.assertEquals("Successful", actualValue.getMessage());

	}
	
	
}
