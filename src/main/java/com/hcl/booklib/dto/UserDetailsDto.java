package com.hcl.booklib.dto;



import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto implements Serializable{

	private static final long serialVersionUID = -7689164648992140575L;

	
	private String userEmail;
	private String userName;
	
	
	
}
