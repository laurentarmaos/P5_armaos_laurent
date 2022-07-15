package com.safetynet.safetynetalert.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.safetynet.safetynetalert.domain.entities.Person;


public interface PersonService {

	JSONArray createPerson(Person dto);
	
	JSONObject getPerson(String firstName, String lastName);
	
	JSONObject updatePerson(String firstName, String lastName);
	
	JSONObject deletePerson(String firstName, String lastName);
}
