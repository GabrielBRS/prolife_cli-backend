package com.gabrielsousa.prolife.dto;

import java.io.Serializable;
import java.util.List;

import com.gabrielsousa.prolife.domain.Users;

public class PatientHistoricalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String email;
	private List<String> consults;
	
	public PatientHistoricalDTO() {
		
	}

	public PatientHistoricalDTO(Users user) {
		super();
		this.id = user.getId();
		this.email = user.getEmail();
	}
}
