package com.gabrielsousa.prolife.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.gabrielsousa.prolife.domain.enums.UsersTypes;
import com.gabrielsousa.prolife.domain.health.Anamnese;

@Entity
@JsonTypeName("doctor_data")
public class Doctor extends Users implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String firstName;

	private String lastName;
	
	private String cpf;
	
	private String crm;
	
	private Integer userType;
	
	private String userTypeDescription;
	
	@ManyToMany(mappedBy = "doctor")
	private List<Anamnese> anamnese = new ArrayList<Anamnese>();
	
	public Doctor() {
		
	}

	public Doctor(Integer id, String email, String password,String firstName,String lastName, String cpf, String crm) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.crm = crm;
		this.userType = UsersTypes.DOCTOR.getCod();
		this.userTypeDescription = UsersTypes.DOCTOR.getDescription();
		addPerfil(UsersTypes.DOCTOR);
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
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

	public List<Anamnese> getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(List<Anamnese> anamnese) {
		this.anamnese = anamnese;
	}

}
