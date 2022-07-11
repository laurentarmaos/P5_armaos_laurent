package com.safetynet.safetynetalert.domain.dtos;

import java.util.HashSet;
import java.util.Set;

public class PersonInfoDto {

	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private double age;
	Set <String> allergies = new HashSet <String>();
	Set<String> medications = new HashSet <String>();
	
	
	public PersonInfoDto(String firstName, String lastName, String address, String email, double age,
			Set<String> allergies, Set<String> medications) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
