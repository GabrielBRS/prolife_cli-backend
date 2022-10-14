package com.gabrielsousa.prolife;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gabrielsousa.prolife.domain.Admin;
import com.gabrielsousa.prolife.domain.Assistant;
import com.gabrielsousa.prolife.domain.Doctor;
import com.gabrielsousa.prolife.domain.Hospital;
import com.gabrielsousa.prolife.domain.Patient;
import com.gabrielsousa.prolife.domain.Users;
import com.gabrielsousa.prolife.repository.DoctorRepository;
import com.gabrielsousa.prolife.repository.HospitalRepository;
import com.gabrielsousa.prolife.repository.PatientHistoricalRepository;
import com.gabrielsousa.prolife.repository.PatientRepository;
import com.gabrielsousa.prolife.repository.UsersRepository;



@SpringBootApplication
public class ProlifeApplication implements CommandLineRunner{
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	PatientHistoricalRepository patientHistoricalRepository;
	
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ProlifeApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		Users hospital1 = new Hospital(null,"hran@gmail.com",passwordEncoder.encode("123456"),"HRAN","778899445566");
		Users hospital2 = new Hospital(null,"hrg@gmail.com",passwordEncoder.encode("123456"),"HRAN","778899445566");
		
		
		
		Users users1 = new Patient(null,"matheusr.sousaa@gmail.com",passwordEncoder.encode("123456"),"Matheus","Barros Rodrigues de Sousa");
		Users users2 = new Doctor(null,"gabriel.brs.gsousaa@gmail.com",passwordEncoder.encode("123456"),"Gabriel","Barros Rodrigues de Sousa","04912788104","1254444");	
		Users users3 = new Assistant(null,"eliane.brs@hotmail.com",passwordEncoder.encode("123456"),"Eliane","Barros Rodrigues de Sousa");
		Users users4 = new Admin(null,"fabio.sousa@gmail.com",passwordEncoder.encode("123456"),"Fábio","Rodrigues de Sousa");
		
//		PatientHistorical patHis1 = new PatientHistorical(null,pat1);
		
		Users users5 = new Patient(null,"matheusr.sousa@gmail.com",passwordEncoder.encode("123456"),"Matheus","Barros Rodrigues de Sousa");
		Users users6 = new Doctor(null,"gabriel.brs.gsousa@gmail.com",passwordEncoder.encode("123456"),"Gabriel","Barros Rodrigues de Sousa","04912788104","1254444");
		
//		Doctor doctor1 = new Doctor(null,"gabriel.brs.gsousa@gmail.com",passwordEncoder.encode("123456"),"Gabriel","Barros Rodrigues de Sousa","04912788104","1254444");
		
//		
		
//		hospitalRepository.saveAll(Arrays.asList(hospital1,hospital2));
		usersRepository.saveAll(Arrays.asList(hospital1,hospital2,users1,users2,users3,users4,users5,users6));
//		patientRepository.saveAll(Arrays.asList(users5));
//		patientHistoricalRepository.saveAll(Arrays.asList(patHis1));
//		doctorRepository.saveAll(Arrays.asList(doctor1));
	}

}
