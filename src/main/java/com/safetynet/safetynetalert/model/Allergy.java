package com.safetynet.safetynetalert.model;

import java.util.HashSet;
import java.util.Set;

public class Allergy extends AbstractModel{

	private String allergyName;
	Set <Person> persons = new HashSet <Person>();
	
	public Allergy() {}
	public Allergy(String allergyName, Set<Person> persons) {
		super();
		this.allergyName = allergyName;
		this.persons = persons;
	}


	
	public String getAllergyName() {
		return allergyName;
	}

	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}


	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	
}
