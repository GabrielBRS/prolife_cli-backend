package com.gabrielsousa.prolife.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.gabrielsousa.prolife.domain.enums.UsersTypes;
import com.gabrielsousa.prolife.domain.health.Anamnese;
import com.gabrielsousa.prolife.domain.health.historicals.PatientHistorical;

@Entity
@JsonTypeName("patient_data")
public class Patient extends Users implements Serializable {
	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;

	private Integer userType;

	private String userTypeDescription;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
	private PatientHistorical patientHistorical;

	@ManyToMany(mappedBy = "patient")
	private List<Anamnese> anamnese = new ArrayList<Anamnese>();

	public Patient() {
		super();
	}

	public Patient(Integer id, String email, String password, String firstName, String lastName) {
		super(id, email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = UsersTypes.PACIENT.getCod();
		this.userTypeDescription = UsersTypes.PACIENT.getDescription();
		addPerfil(UsersTypes.PACIENT);
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

	public List<Anamnese> getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(List<Anamnese> anamnese) {
		this.anamnese = anamnese;
	}
	
}
