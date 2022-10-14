package com.gabrielsousa.prolife.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielsousa.prolife.domain.health.historicals.PatientHistorical;

@Transactional
@Repository
public interface PatientHistoricalRepository extends JpaRepository<PatientHistorical, Integer> {

//	@Transactional
//	Users findByEmail(String email);
}
