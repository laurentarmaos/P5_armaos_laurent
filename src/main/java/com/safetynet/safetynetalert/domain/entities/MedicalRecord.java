package com.safetynet.safetynetalert.domain.entities;

import java.util.Date;
import java.util.Set;

public class MedicalRecord {

	private String firstName;
	private String lastName;
	private Date birthDate;
	private Set<String> medications;
	private Set<String> allergies;
	
	public MedicalRecord() {
		
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
