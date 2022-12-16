package com.ExponeServicio.dao;

import java.sql.*;
import java.util.*;

import javax.persistence.Column;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ExponeServicio.entity.Patient;

@Repository
public class PatientDAOJdbcImpl implements PatientDao {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Patient> findAll() {
		System.out.println("Implementación DAO con JDBC findAll(): " + dataSource);

		List<Patient> listaPacientes = new ArrayList<>();

		String sql = "select * from patient";

		try (Connection myConn = dataSource.getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery(sql);) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				
				int id = myRs.getInt("id");
				String fullName = myRs.getString("full_name");
				String patientNumber = myRs.getString("patient_number");
				String personal = myRs.getString("personal");
				String hospital = myRs.getString("hospital");
				String temperature = myRs.getString("temperature");

				// create new student object
				Patient tempPatient = new Patient(id, fullName, patientNumber, personal, hospital, temperature);

				// add it to the list of students
				listaPacientes.add(tempPatient);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaPacientes;
	}

	@Override
	public Patient findById(int theId) {
		
		System.out.println("Implementación DAO con JDBC findById(): ");
		Patient thePatient = null;

		try (Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = createPreparedStatement(myConn, theId);
			ResultSet myRs = myStmt.executeQuery();) {

			// retrieve data from result set row
			if (myRs.next()) {
				
				int id = myRs.getInt("id");
				String fullName = myRs.getString("full_name");
				String patientNumber = myRs.getString("patient_number");
				String personal = myRs.getString("personal");
				String hospital = myRs.getString("hospital");
				String temperature = myRs.getString("temperature");

				// use the studentId during construction
				Patient tempPatient = new Patient(id, fullName, patientNumber, personal, hospital, temperature);
			} else {
				throw new SQLException("Could not find employee id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thePatient;
	}

	private PreparedStatement createPreparedStatement(Connection con, int patientId) throws SQLException {
		String sql = "select * from patient where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, patientId);
		return ps;
	}

	@Override
	public void save(Patient thePatient) {
		String sql = "";

		if (thePatient.getId() == 0)
			sql = "insert into patient (full_name, patient_number, personal, hospital, temperature) values (?, ?, ?, ?, ?)";
		else
			sql = "update patient set full_name=?, patient_number=?, personal=?, hospital=?, temperature=? where id=?";

		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql)) {

			myStmt.setString(1, thePatient.getFullName());
			myStmt.setString(2, thePatient.getPatientNumber());
			myStmt.setString(3, thePatient.getPersonal());
			myStmt.setString(4, thePatient.getHospital());
			myStmt.setString(5, thePatient.getTemperature());

			if (thePatient.getId() != 0)
				myStmt.setInt(6, thePatient.getId());

			myStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteById(int theId) {
		
		try (Connection myConn = dataSource.getConnection(); 
			 PreparedStatement myStmt = myConn.prepareStatement("delete from patient where id=?")) {
			
			myStmt.setInt(1, theId);
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
