package com.ExponeServicio.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ExponeServicio.entity.Patient;
import com.ExponeServicio.service.PatientService;

@Controller
@RequestMapping("/mvc")
public class PatientMvcController {

	// need to inject our customer service
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/Patients")
	public String listPatients(Model theModel) {
		
		// get customers from the service
		List<Patient> thePatients = patientService.findAll();
				
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
		
		// save the patient using our service
		patientService.save(thePatient);	
		
		return "redirect:/mvc/Patients";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("patientId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Patient thePatient = patientService.findById(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("patient", thePatient);
		
		// send over to our form		
		return "patient-form";
	}
	
	@GetMapping("/delete")
	public String deletePatient(@RequestParam("patientId") int theId) {
		
		// delete the customer
		patientService.deleteById(theId);
		
		return "redirect:/mvc/Patients";
	}

}










