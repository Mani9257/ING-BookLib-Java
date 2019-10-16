package com.hcl.booklib.dto;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class UserLoginDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;

}
