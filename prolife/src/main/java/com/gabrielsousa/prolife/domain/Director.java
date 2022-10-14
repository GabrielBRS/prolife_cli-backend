package com.gabrielsousa.prolife.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import com.gabrielsousa.prolife.domain.enums.UsersTypes;

@Entity
public class Director extends Users implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private UsersTypes usersTypes;
	
	public Director() {
		
	}

	public Director(Integer id, String email, String password, String name) {
		super(id, email, password);
		this.name = name;
		this.usersTypes = UsersTypes.ASSISTANT;
		addPerfil(usersTypes);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
