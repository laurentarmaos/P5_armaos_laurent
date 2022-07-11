package com.safetynet.safetynetalert.domain.dtos;

import java.util.HashSet;
import java.util.Set;

public class FireAlertDto {
	
	private String firstName;
	private String lastName;
	private String phone;
	private double age;
	Set <String> allergies = new HashSet <String>();
	Set<String> medications = new HashSet <String>();
	
	
	public FireAlertDto(String firstName, String lastName, String phone, double age, Set<String> allergies,
			Set<String> medications) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.age = age;
		this.allergies = allergies;
		this.medications = medications;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public double getAge() {
		return age;
	}


	public void setAge(double age) {
		this.age = age;
	}


	public Set<String> getAllergies() {
		return allergies;
	}


	public void setAllergies(Set<String> allergies) {
		this.allergies = allergies;
	}


	public Set<String> getMedications() {
		return medications;
	}


	public void setMedications(Set<String> medications) {
		this.medications = medications;
	}
	
	
	

}
