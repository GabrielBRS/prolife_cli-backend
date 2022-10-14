package com.gabrielsousa.prolife.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielsousa.prolife.domain.Doctor;

@Transactional
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
