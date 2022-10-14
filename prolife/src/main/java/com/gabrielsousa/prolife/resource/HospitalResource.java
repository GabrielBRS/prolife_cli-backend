package com.gabrielsousa.prolife.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsousa.prolife.domain.Hospital;
import com.gabrielsousa.prolife.service.HospitalService;

@RestController
@RequestMapping(value="/hospital")
public class HospitalResource {

	@Autowired
	private HospitalService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Hospital obj = service.find(id);	
		return ResponseEntity.ok().body(obj);
	}
}
