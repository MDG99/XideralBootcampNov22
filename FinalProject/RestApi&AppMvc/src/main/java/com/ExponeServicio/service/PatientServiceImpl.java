package com.ExponeServicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ExponeServicio.dao.PatientDao;
import com.ExponeServicio.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	
	private PatientDao patientDAO;
	
	@Autowired
	public PatientServiceImpl(@Qualifier("patientDAOHibernateImpl") PatientDao thePatientDAO) {
		patientDAO = thePatientDAO;
	}
	
	@Override
	@Transactional
	public List<Patient> findAll() {
		return patientDAO.findAll();
	}

	@Override
	@Transactional
	public Patient findById(int theId) {
		return patientDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Patient thePatient) {
		patientDAO.save(thePatient);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		patientDAO.deleteById(theId);
	}

}






