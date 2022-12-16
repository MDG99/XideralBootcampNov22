package com.ExponeServicio.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ExponeServicio.entity.Patient;

@Repository
public class PatientDAOHibernateImpl implements PatientDao {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public PatientDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Patient> findAll() {
		System.out.println("EmployeeDAOHibernateImpl");
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Patient> theQuery =
				currentSession.createQuery("from Patient", Patient.class);
		
		// execute query and get result list
		List<Patient> patients = theQuery.getResultList();
		
		// return the results		
		return patients;
	}


	@Override
	public Patient findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Patient thePatient =
				currentSession.get(Patient.class, theId);
		
		// return the employee
		return thePatient;
	}


	@Override
	public void save(Patient thePatient) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(thePatient);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Patient where id=:patientId");
		
		theQuery.setParameter("patientId", theId);
		
		theQuery.executeUpdate();
	}

}







