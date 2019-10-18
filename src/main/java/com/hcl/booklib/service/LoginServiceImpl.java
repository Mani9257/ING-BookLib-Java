package com.hcl.booklib.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.booklib.constants.LibraryConstants;
import com.hcl.booklib.dto.LoginResponseDto;
import com.hcl.booklib.dto.UserLoginDto;
import com.hcl.booklib.entity.User;
import com.hcl.booklib.exception.UserDoesNotExistException;
import com.hcl.booklib.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LibraryConstants constants;

	/**
	 * @author Sucheta This method is intended to login the user by taking userid
	 *         and password for login
	 * @param loginDto is the input request which includes userid and password
	 * @return it returns "login successful" message
	 * @throws UserDoesNotExistException 
	 */

	@Override
	public LoginResponseDto loginUser(UserLoginDto loginDto) throws UserDoesNotExistException {

		User user = userRepository.findByUserNameAndPassword(loginDto.getUserName(), loginDto.getPassword());
		LOGGER.info("inside login");
		if(user!=null) {

			if ( user.getPassword().equalsIgnoreCase(loginDto.getPassword()) && user.getUserName().equalsIgnoreCase(loginDto.getUserName() )) {
				LoginResponseDto loginResponseDto1 = new LoginResponseDto();
				loginResponseDto1.setUserId(user.getUserId());
				loginResponseDto1.setStatusCode(LibraryConstants.SUCCESS_STATUS_CODE);
				loginResponseDto1.setMessage(LibraryConstants.SUCCESS_STATUS_MESSAGE);
				return loginResponseDto1;
				
				}
			
			else {
				throw new UserDoesNotExistException("user doesnt exist");
			
		}}
			
	else {
		throw new UserDoesNotExistException("user doesnt exist");
	}
	}


}