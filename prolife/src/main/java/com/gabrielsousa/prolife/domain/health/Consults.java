package com.gabrielsousa.prolife.domain.health;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.gabrielsousa.prolife.domain.Patient;

@Entity
public class Consults implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String patientName;
	
	private String doctorName;
	
	private Date dateConsult;
	
	public Consults() {
		
	}

	public Consults(Patient patient) {
		this.patientName = patient.getFirstName();
	}
}
