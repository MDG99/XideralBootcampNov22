package com.ConsumeServicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ConsumeServicio.model.Patient;
import com.ConsumeServicio.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	// need to inject our customer service
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/list")
	public String listPatients(Model theModel) {
		
		// get customers from the service
		List<Patient> thePatients = patientService.getPatients();
				
		// add the customers to the model
		theModel.addAttribute("patients", thePatients);
		
		return "list-patients";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Patient thePatient = new Patient();
		
		theModel.addAttribute("patient", thePatient);
		
		return "patient-form";
	}
	
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient thePatient) {
		
		// save the customer using our service
		patientService.savePatient(thePatient);	
		
		return "redirect:/patient/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("patientId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Patient thePatient = patientService.getPatient(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("patient", thePatient);
		
		// send over to our form		
		return "patient-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("patientId") int theId) {
		
		// delete the customer
		patientService.deletePatient(theId);
		
		return "redirect:/patient/list";
	}
}










