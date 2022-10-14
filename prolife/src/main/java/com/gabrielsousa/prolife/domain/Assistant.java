package com.gabrielsousa.prolife.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import com.gabrielsousa.prolife.domain.enums.UsersTypes;

@Entity
public class Assistant extends Users implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fristName;

	private String lastName;
	
	private UsersTypes usersTypes;
	
	public Assistant() {
		
	}

	public Assistant(Integer id, String email, String password, String fristName, String lastName) {
		super(id, email, password);
		this.fristName = fristName;
		this.lastName =lastName;
		this.usersTypes = UsersTypes.ASSISTANT;
		addPerfil(usersTypes);
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
