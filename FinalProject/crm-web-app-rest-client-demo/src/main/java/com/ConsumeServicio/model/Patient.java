package com.ConsumeServicio.model;


public class Patient {
	
	private int id;
	private String fullName;
	private String patientNumber;
	private String personal;
	private String hospital;
	private String temperature;
	
	public Patient() {
		
	}
	
	
	public Patient(int id, String fullName, String patientNumber, String personal, String hospital,
			String temperature) {
		this.id = id;
		this.fullName = fullName;
		this.patientNumber = patientNumber;
		this.personal = personal;
		this.hospital = hospital;
		this.temperature = temperature;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPatientNumber() {
		return patientNumber;
	}
	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}


	@Override
	public String toString() {
		return "Patient [id=" + id + ", fullName=" + fullName + ", patientNumber=" + patientNumber + ", personal="
				+ personal + ", hospital=" + hospital + ", temperature=" + temperature + "]";
	}

	

}
