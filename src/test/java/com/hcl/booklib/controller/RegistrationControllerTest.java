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
import com.hcl.booklib.dto.RegistrationResponseDto;
import com.hcl.booklib.dto.UserDetailsDto;
import com.hcl.booklib.entity.User;
import com.hcl.booklib.exception.UserDoesNotExistException;
import com.hcl.booklib.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class RegistrationControllerTest {

	@InjectMocks
	RegistrationController registrationController;

	@Mock
	UserService userService;

	private MockMvc mockMvc;

	RegistrationResponseDto registrationResponseDto = new RegistrationResponseDto();
	UserDetailsDto userDetailsDto = new UserDetailsDto();
	User user = new User();

	@Before
	public void setUp() {

		mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
		registrationResponseDto.setStatusCode(201);
		registrationResponseDto.setStatusMessage("SUCCESS");
		registrationResponseDto.setUserId(1);

		userDetailsDto.setUserEmail("suchita@gmail.com");
		userDetailsDto.setUserName("Suchita");

		user.setUserId(1);
		user.setUserName("Suchita");
		user.setUserEmail("suchita@gmail.com");

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testRegistration() throws UserDoesNotExistException {

		Mockito.when(userService.registration(Mockito.any())).thenReturn(registrationResponseDto);

		ResponseEntity<RegistrationResponseDto> response = registrationController.registration(Mockito.any());

		assertEquals(201, response.getStatusCodeValue());
	}

}
