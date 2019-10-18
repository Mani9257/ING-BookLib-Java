package com.hcl.booklib.service;

import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.booklib.constants.LibraryConstants;
import com.hcl.booklib.dto.RegistrationResponseDto;
import com.hcl.booklib.dto.UserDetailsDto;
import com.hcl.booklib.entity.User;
import com.hcl.booklib.exception.EmailException;
import com.hcl.booklib.exception.UserDoesNotExistException;
import com.hcl.booklib.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;
	LibraryConstants constants;
	

	SecureRandom random1 = new SecureRandom();

	@Override
	public RegistrationResponseDto registration(UserDetailsDto userDetailsDto) throws UserDoesNotExistException {
		LOGGER.debug("UserServiceImpl of register()");
		RegistrationResponseDto registrationResponseDto = new RegistrationResponseDto();
		User user = new User();

		if (userDetailsDto != null) {

			if (emailValidation(userDetailsDto.getUserEmail())) {

			

				BeanUtils.copyProperties(userDetailsDto, user);

				user.setPassword(generatePassword("password"));
				userRepository.save(user);

			
				registrationResponseDto.setUserId(user.getUserId());

				registrationResponseDto.setStatusCode(LibraryConstants.SUCCESS_STATUS_CODE);
				registrationResponseDto.setStatusMessage(LibraryConstants.SUCCESS_STATUS_MESSAGE);

				

			} else {
				throw new EmailException("Enter Valid Email...");
			}

		}
		else {
			throw new UserDoesNotExistException("");
		}
		return registrationResponseDto;
	}

	static boolean emailValidation(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public String generatePassword(String dic) {
		int len = 6;
		String result = "";
		for (int i = 0; i < len; i++) {
			int index = random1.nextInt(dic.length());
			result += dic.charAt(index);
		}
		return result;
	}
}
