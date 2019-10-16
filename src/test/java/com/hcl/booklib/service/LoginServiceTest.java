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

	User user;
	UserLoginDto loginDto;

	@Before
	public void init() {

		user = new User();
		user.setUserId(1);
		user.setUserName("sucheta");
		user.setPassword("chandu12");
		

		loginDto = new UserLoginDto();
		loginDto.setUserName("sucheta");
		loginDto.setPassword("chandu12");

	}

	@Test
	public void UserLogin() {

		UserLoginDto loginDto=new UserLoginDto();
		loginDto.setUserName("sucheta");
		loginDto.setPassword("ok");
		Mockito.when(userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword())
				.thenReturn(user));
		LoginResponseDto actualValue = LoginServiceImpl.loginUser(loginDto);
		Assert.assertEquals("invalid credentials", actualValue.getMessage());

	}
}
