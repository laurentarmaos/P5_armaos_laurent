package com.safetynet.safetynetalert.domain.dtos;

import java.util.HashSet;
import java.util.Set;


public class MedicationDto {

	private String medicationName;
	//Set <PersonDto> persons = new HashSet <PersonDto>();
	
	public MedicationDto() {}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

//	public Set<PersonDto> getPersons() {
//		return persons;
//	}
//
//	public void setPersons(Set<PersonDto> persons) {
//		this.persons = persons;
//	}

	@Override
	public String toString() {
		return "MedicationDto [medicationName=" + medicationName + "]";
	}

	
}
