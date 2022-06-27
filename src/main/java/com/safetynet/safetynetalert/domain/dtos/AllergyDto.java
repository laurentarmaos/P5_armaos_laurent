package com.safetynet.safetynetalert.domain.dtos;

import java.util.HashSet;
import java.util.Set;


public class AllergyDto {

	private String allergyName;
	Set <PersonDto> persons = new HashSet <PersonDto>();
	
	public AllergyDto() {
		
	}

	public String getAllergyName() {
		return allergyName;
	}

	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}

	public Set<PersonDto> getPersons() {
		return persons;
	}

	public void setPersons(Set<PersonDto> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "AllergyDto [allergyName=" + allergyName + ", persons=" + persons + "]";
	}
	
	

}
