package com.gabrielsousa.prolife.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.gabrielsousa.prolife.domain.enums.UsersTypes;
import com.gabrielsousa.prolife.domain.health.historicals.PatientHistorical;

@Entity
@JsonTypeName("patient_data")
public class Patient extends Users implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fristName;

	private String lastName;

	private Integer userType;

	private String userTypeDescription;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
	private PatientHistorical patientHistorical;

	public Patient() {
		super();
	}

	public Patient(Integer id, String email, String password, String fristName, String lastName) {
		super(id, email, password);
		this.fristName = fristName;
		this.lastName = lastName;
		this.userType = UsersTypes.PACIENT.getCod();
		this.userTypeDescription = UsersTypes.PACIENT.getDescription();
	}

//	public Patient(Integer id, String fristName, String lastName, String email, String cpf, String password,
//			UsersTypes userType) {
//		super(id, fristName, lastName, email, cpf, password);
////		this.name = nameTest;
////		this.patientHistorical = patientHistorical;
////		this.userType = (userType==null)?null:userType.getCod();
//		this.userType = UsersTypes.PACIENT.getCod();
//	}

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

	public void setUserTypeDescription(String userTypeDescription) {
		this.userTypeDescription = userTypeDescription;
	}

	public PatientHistorical getPatientHistorical() {
		return patientHistorical;
	}

	public void setPatientHistorical(PatientHistorical patientHistorical) {
		this.patientHistorical = patientHistorical;
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

	public void setUserTypeDescription(UsersTypes userTypeDescription) {
		this.userTypeDescription = userTypeDescription.getDescription();
	}

}
