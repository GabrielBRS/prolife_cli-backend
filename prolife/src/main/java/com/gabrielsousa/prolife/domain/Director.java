package com.gabrielsousa.prolife.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import com.gabrielsousa.prolife.domain.enums.UsersTypes;

@Entity
public class Director extends Users implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private Integer userType;
	
	private String userTypeDescription;
	
	public Director() {
		
	}

	public Director(Integer id, String email, String password, String name) {
		super(id, email, password);
		this.name = name;
		this.userType = UsersTypes.DIRECTOR.getCod();
		this.userTypeDescription = UsersTypes.DIRECTOR.getDescription();
		addPerfil(UsersTypes.DIRECTOR);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUserTypeDescription() {
		return userTypeDescription;
	}

	public void setUserTypeDescription(String userTypeDescription) {
		this.userTypeDescription = userTypeDescription;
	}
	
}
