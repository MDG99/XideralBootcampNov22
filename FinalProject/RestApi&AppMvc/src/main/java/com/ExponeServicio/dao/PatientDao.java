package com.ExponeServicio.dao;

import com.ExponeServicio.entity.Patient;
import java.util.List;


public interface PatientDao {

	List<Patient> findAll();
	
	Patient findById(int theId);
	
	void save(Patient thePatient);
	
	void deleteById(int theId);
	
}