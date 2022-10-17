package com.gabrielsousa.prolife.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielsousa.prolife.domain.Patient;
import com.gabrielsousa.prolife.domain.Users;
import com.gabrielsousa.prolife.domain.enums.UsersTypes;
import com.gabrielsousa.prolife.repository.PatientRepository;
import com.gabrielsousa.prolife.security.UserSS;
import com.gabrielsousa.prolife.service.auth.UserService;
import com.gabrielsousa.prolife.service.exception.AuthorizationException;
import com.gabrielsousa.prolife.service.exception.ObjectNotFoundException;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	public Patient find(Integer id){
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(UsersTypes.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Patient> obj = patientRepository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Users.class.getName())); 
	}
	
	public List<Patient> findAll(){
		 List<Patient> obj = patientRepository.findAll();
		 return obj;
	}
}
