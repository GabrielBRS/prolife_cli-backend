package com.gabrielsousa.prolife.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielsousa.prolife.domain.Hospital;
import com.gabrielsousa.prolife.repository.HospitalRepository;
import com.gabrielsousa.prolife.service.exception.ObjectNotFoundException;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	public Hospital find(Integer id) {
		Optional<Hospital> obj = hospitalRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Hospital.class.getName()));
	}
	
	public Hospital insert(Hospital obj) {
		obj.setId(null);
		return hospitalRepository.save(obj);
	}
}
