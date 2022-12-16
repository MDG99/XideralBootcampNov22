package com.ExponeServicio.service;

import java.util.List;
import com.ExponeServicio.entity.Patient;

public interface PatientService {

	public List<Patient> findAll();
	
	public Patient findById(int theId);
	
	public void save(Patient theEmployee);
	
	public void deleteById(int theId);
	
}
