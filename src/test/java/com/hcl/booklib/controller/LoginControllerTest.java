package com.hcl.booklib.controller;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.booklib.dto.LoginResponseDto;
import com.hcl.booklib.dto.UserLoginDto;
import com.hcl.booklib.entity.User;
import com.hcl.booklib.service.LoginService;
import com.hcl.booklib.service.LoginServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginController.class)

public class LoginControllerTest {

	
	@Autowired
    MockMvc mockMvc;
	
	@MockBean
	LoginServiceImpl loginServiceImpl;

	User user;
	UserLoginDto loginDto;
	LoginResponseDto loginResponseDto;
	@Before
	public void init() {
		
		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("login successfull");
		user = new User();

		loginDto = new UserLoginDto();

		mockMvc = MockMvcBuilders.standaloneSetup(loginServiceImpl).build();

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
		Mockito.when(loginServiceImpl.loginUser(loginDto)).thenReturn(loginResponseDto);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/login").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(loginResponseDto))).andReturn();

	}

}
