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
import com.hcl.booklib.repository.UserRepository;

@RunWith(SpringRunner.class)
public class LoginServiceTest {

	@InjectMocks
	LoginServiceImpl LoginServiceImpl;

	@Mock
	UserRepository userRepository;

	@Before
	public void init() {

	}

	@Test
	public void login() {

		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("Successful");
		loginResponseDto.setStatusCode(200);
		loginResponseDto.setUserId(1);

		User user = new User();
		user.setPassword("Suchita");
		user.setUserId(1);
		user.setUserName("Suchita");

		UserLoginDto loginDto = new UserLoginDto();
		loginDto.setPassword("Suchita");
		loginDto.setUserName("Suchita");

		Mockito.when(userRepository.findByUserNameAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(user);
		LoginResponseDto actualValue = LoginServiceImpl.loginUser(loginDto);
		Assert.assertEquals("Successful", actualValue.getMessage());

	}
}
