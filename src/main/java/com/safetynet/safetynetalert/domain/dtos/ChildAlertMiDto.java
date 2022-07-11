package com.safetynet.safetynetalert.domain.dtos;

public class ChildAlertMiDto {
	
	private String firstName;
	private String lastName;
	private double age;
	
	
	public ChildAlertMiDto(String firstName, String lastName, double age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
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


	public double getAge() {
		return age;
	}


	public void setAge(double age) {
		this.age = age;
	}
	
	
	

}
