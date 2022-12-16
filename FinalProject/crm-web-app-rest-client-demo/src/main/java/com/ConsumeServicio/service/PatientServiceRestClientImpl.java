package com.ConsumeServicio.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ConsumeServicio.model.Patient;

@Service
public class PatientServiceRestClientImpl implements PatientService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public PatientServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Patient> getPatients() {
		
		logger.info("***OBTENER LISTA DE CLIENTES DESDE EL SERVICE REST CLIENTE");
		logger.info("in getCustomers(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Patient>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Patient>>() {});

		// get the list of customers from response
		List<Patient> patients = responseEntity.getBody();

		logger.info("in getCustomers(): customers" + patients);
		
		return patients;
	}

	@Override
	public Patient getPatient(int theId) {
		logger.info("***OBTENER UN CLIENTE DESDE EL SERVICE REST CLIENTE");

		logger.info("in getCustomer(): Calling REST API " + crmRestUrl);

		// make REST call
		Patient thePatient = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Patient.class);

		logger.info("in saveCustomer(): theCustomer=" + thePatient);
		
		return thePatient;
	}

	@Override
	public void savePatient(Patient thePatient) {

		logger.info("in saveCustomer(): Calling REST API " + crmRestUrl);
		
		int patientId = thePatient.getId();

		// make REST call
		if (patientId == 0) {
			// add employee
			logger.info("***SALVAR UN CLIENTE DESDE EL SERVICE REST CLIENTE");

			restTemplate.postForEntity(crmRestUrl, thePatient, String.class);			
		
		} else {
			// update employee
			logger.info("***ACTUALIZAR UN CLIENTE DESDE EL SERVICE REST CLIENTE");

			restTemplate.put(crmRestUrl, thePatient);
		}

		logger.info("in saveCustomer(): success");	
	}

	@Override
	public void deletePatient(int theId) {
		logger.info("***BORRAR UN CLIENTE DESDE EL SERVICE REST CLIENTE");

		logger.info("in deleteCustomer(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteCustomer(): deleted customer theId=" + theId);
	}

}
