package com.gabrielsousa.prolife.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsousa.prolife.domain.Doctor;
import com.gabrielsousa.prolife.service.DoctorService;

@RestController
@RequestMapping(value="/doctor")
public class DoctorResource {

//	@Autowired	
//	private UsersService usersService;
	
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Doctor> find(@PathVariable Integer id) {
		Doctor obj = doctorService.find(id);	
		return ResponseEntity.ok().body(obj);
	}
	
}
