package com.gabrielsousa.prolife.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielsousa.prolife.domain.Users;
import com.gabrielsousa.prolife.domain.enums.UsersTypes;
import com.gabrielsousa.prolife.repository.UsersRepository;
import com.gabrielsousa.prolife.security.UserSS;
import com.gabrielsousa.prolife.service.auth.UserService;
import com.gabrielsousa.prolife.service.exception.AuthorizationException;
import com.gabrielsousa.prolife.service.exception.ObjectNotFoundException;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	public Users find(Integer id){
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasRole(UsersTypes.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Users> obj = usersRepository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Users.class.getName())); 
	}
	
	public Users findByEmail(String email) {
		Users obj = usersRepository.findByEmail(email);
		obj.addPerfil(UsersTypes.ADMIN);
		return obj;
	}
	
	public List<Users> findAll(){
		List<Users> obj = usersRepository.findAll();
		return obj;
	}
}
