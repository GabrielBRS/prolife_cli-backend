package com.gabrielsousa.prolife.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielsousa.prolife.domain.Users;
import com.gabrielsousa.prolife.service.UsersService;

@RestController
@RequestMapping(value="/users")
public class UsersResource {

	@Autowired	
	private UsersService usersService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Users obj = usersService.find(id);	
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{email}" ,method = RequestMethod.POST)
	public ResponseEntity<?> findByEmail(@PathVariable String email){
		Users obj = usersService.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Users> obj = usersService.findAll();	
		return ResponseEntity.ok().body(obj);
	}
}
