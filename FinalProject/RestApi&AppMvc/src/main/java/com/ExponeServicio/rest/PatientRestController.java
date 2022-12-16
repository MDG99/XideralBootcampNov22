package com.ExponeServicio.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExponeServicio.entity.Patient;
import com.ExponeServicio.service.PatientService;

@RestController
@RequestMapping("/rest")
public class PatientRestController {

	private PatientService patientService;
	
	@Autowired
	public PatientRestController(PatientService thePatientService) {
		patientService = thePatientService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/patients")
	public List<Patient> findAll() {
		return patientService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/patients/{patientId}")
	public Patient getPatient(@PathVariable int patientId) throws Exception {
		
		Patient thePatient = patientService.findById(patientId);
		
		if (thePatient == null) {
			throw new Exception("Patient id not found - " + patientId);
		}
		
		return thePatient;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/patients")
	public Patient addPatient(@RequestBody Patient thePatient) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		thePatient.setId(0);
		
		patientService.save(thePatient);
		
		return thePatient;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/patients")
	public Patient updatePatient(@RequestBody Patient thePatient) {
		
		patientService.save(thePatient);
		
		return thePatient;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/patients/{patientId}")
	public String deletePatient(@PathVariable int patientId) {
		
		Patient tempEmployee = patientService.findById(patientId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("Patient id not found - " + patientId);
		}
		
		patientService.deleteById(patientId);
		
		return "Deleted Patient id - " + patientId;
	}
	
}










