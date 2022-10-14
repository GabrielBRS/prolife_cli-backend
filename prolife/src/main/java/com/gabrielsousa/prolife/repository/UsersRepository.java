package com.gabrielsousa.prolife.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielsousa.prolife.domain.Users;

@Transactional
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	@Transactional
	Users findByEmail(String email);
	
}
