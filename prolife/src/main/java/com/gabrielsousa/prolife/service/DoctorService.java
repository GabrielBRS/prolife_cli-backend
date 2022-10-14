package com.gabrielsousa.prolife.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielsousa.prolife.domain.Doctor;
import com.gabrielsousa.prolife.domain.Users;
import com.gabrielsousa.prolife.domain.enums.UsersTypes;
import com.gabrielsousa.prolife.repository.DoctorRepository;
import com.gabrielsousa.prolife.security.UserSS;
import com.gabrielsousa.prolife.service.auth.UserService;
import com.gabrielsousa.prolife.service.exception.AuthorizationException;
import com.gabrielsousa.prolife.service.exception.ObjectNotFoundException;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	public Doctor find(Integer id){
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(UsersTypes.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Doctor> obj = doctorRepository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Users.class.getName())); 
	}
}
