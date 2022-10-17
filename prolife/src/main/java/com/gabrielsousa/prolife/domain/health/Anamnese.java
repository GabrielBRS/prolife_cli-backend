package com.gabrielsousa.prolife.domain.health;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabrielsousa.prolife.domain.Doctor;
import com.gabrielsousa.prolife.domain.Patient;

@Entity
public class Anamnese implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
			  name = "PATIENT_ANAMNESE", 
			  joinColumns = @JoinColumn(name = "anamnese_id"), 
			  inverseJoinColumns = @JoinColumn(name = "patient_id"))
	private List<Patient> patient = new ArrayList<Patient>() ;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			  name = "DOCTOR_ANAMNESE", 
			  joinColumns = @JoinColumn(name = "anamnese_id"), 
			  inverseJoinColumns = @JoinColumn(name = "doctor_id"))
	private List<Doctor> doctor = new ArrayList<Doctor>();
	
	private String date;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="DISEASE")
	private List<String> disease;
	
	public Anamnese() {
		
	}

	public Anamnese(Integer id, List<Patient> patient, List<Doctor> doctor, List<String> disease) {
		super();
		this.id = id;
		this.patient = patient;
		this.doctor = doctor;
		this.disease = disease;
		this.date = setDate();
	}

	public String setDate(){
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		var dateFormated = date.format(myFormatObj);
		return dateFormated;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	public List<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}

	public List<String> getDisease() {
		return disease;
	}

	public void setDisease(List<String> disease) {
		this.disease = disease;
	}

	public String getDate() {
		return date;
	}

	public void String(String date) {
		this.date = date;
	}

}
