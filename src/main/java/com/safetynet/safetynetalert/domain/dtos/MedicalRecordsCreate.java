package com.safetynet.safetynetalert.domain.dtos;

import java.util.Set;

public class MedicalRecordsCreate {

	private String firstName;
	private String lastName;
	private String birthdate;
	private Set<String> medications;
	private Set<String> allergies;
	
	public MedicalRecordsCreate() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public Set<String> getMedications() {
		return medications;
	}

	public void setMedications(Set<String> medications) {
		this.medications = medications;
	}

	public Set<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(Set<String> allergies) {
		this.allergies = allergies;
	}
	
	
	
}
