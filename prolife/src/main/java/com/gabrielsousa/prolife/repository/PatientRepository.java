package com.gabrielsousa.prolife.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielsousa.prolife.domain.Patient;

@Transactional
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

//	@Transactional
//	Patient findByEmail(String email);
	
}
