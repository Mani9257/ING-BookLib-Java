package com.hcl.booklib.dto;



import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDetailsDto implements Serializable{

	private static final long serialVersionUID = -7689164648992140575L;

	
	private String userEmail;
	private String userName;
	
	
	
}
