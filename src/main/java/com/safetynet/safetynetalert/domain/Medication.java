package com.safetynet.safetynetalert.domain;

import java.util.HashSet;
import java.util.Set;

public class Medication extends AbstractModel{

	private String medicationName;
	Set <Person> persons = new HashSet <Person>();
	
	
	public Medication() {}
	public Medication(String medicationName, Set<Person> persons) {
		super();
		this.medicationName = medicationName;
		this.persons = persons;
	}


	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}


	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	
	
	
}
