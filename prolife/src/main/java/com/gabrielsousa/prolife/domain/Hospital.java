package com.gabrielsousa.prolife.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gabrielsousa.prolife.domain.enums.UsersTypes;

@Entity
//@Table(name="MY_HOSPITAL_TABLE")
public class Hospital extends Users implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String cnpj;
	
	private Integer userType;
	
	private String userTypeDescription;
	
	@ManyToOne
	@JoinColumn(name="organization_id")
	private Organization organization;
	
	public Hospital() {
		
	}

	public Hospital(Integer id, String email, String password, String name, String cnpj) {
		super(id, email, password);
		this.name = name;
		this.cnpj = cnpj;
		this.userType = UsersTypes.HOSPITAL.getCod();
		this.userTypeDescription = UsersTypes.HOSPITAL.getDescription();
		addPerfil(UsersTypes.HOSPITAL);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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
