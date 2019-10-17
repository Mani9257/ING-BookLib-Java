package com.hcl.booklib.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.booklib.dto.LoginResponseDto;
import com.hcl.booklib.dto.UserLoginDto;
import com.hcl.booklib.entity.User;
import com.hcl.booklib.service.LoginServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoginControllerTest {

	@InjectMocks
	LoginController loginController;

	@Mock
	LoginServiceImpl loginServiceImpl;

	private MockMvc mockMvc;

	@Before
	public void setUp() {

		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void loginUser() throws Exception {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("login successfull");
		loginResponseDto.setStatusCode(200);
		loginResponseDto.setUserId(1);

		User user = new User();
		user.setPassword("Suchita");
		user.setUserId(1);
		user.setUserName("Suchita");

		UserLoginDto loginDto = new UserLoginDto();
		loginDto.setPassword("Suchita");
		loginDto.setUserName("Suchita");

		Mockito.when(loginServiceImpl.loginUser(Mockito.any())).thenReturn(loginResponseDto);

		ResponseEntity<LoginResponseDto> response = loginController.loginUser(Mockito.any());

		assertEquals(200, response.getStatusCodeValue());
	}

}
