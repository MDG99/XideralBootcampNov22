package com.ConsumeServicio.service;

import java.util.List;

import com.ConsumeServicio.model.Patient;

public interface PatientService {

	public List<Patient> getPatients();

	public void savePatient(Patient theCustomer);

	public Patient getPatient(int theId);

	public void deletePatient(int theId);
	
}
