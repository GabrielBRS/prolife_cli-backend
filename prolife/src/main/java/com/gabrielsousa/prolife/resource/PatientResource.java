package com.gabrielsousa.prolife.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsousa.prolife.domain.Patient;
import com.gabrielsousa.prolife.service.PatientService;

@RestController
@RequestMapping(value="/patient")
public class PatientResource {

//	@Autowired	
//	private UsersService usersService;
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Patient> find(@PathVariable Integer id) {
		Patient obj = patientService.find(id);	
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method =RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Patient> obj = patientService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
}
