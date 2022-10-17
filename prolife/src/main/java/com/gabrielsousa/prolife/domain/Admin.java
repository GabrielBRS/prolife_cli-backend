package com.gabrielsousa.prolife.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import com.gabrielsousa.prolife.domain.enums.UsersTypes;

@Entity
public class Admin extends Users implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	
	private String lastName;
	
	private Integer userType;
	
	private String userTypeDescription;
	
	public Admin() {
		
	}

	public Admin(Integer id, String email, String password, String firstName,String lastName) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = UsersTypes.ADMIN.getCod();
		this.userTypeDescription = UsersTypes.ADMIN.getDescription();
		addPerfil(UsersTypes.ADMIN);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
