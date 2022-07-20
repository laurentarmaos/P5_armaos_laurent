package com.safetynet.safetynetalert.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.safetynet.safetynetalert.domain.dtos.PersonCreate;


public interface PersonService {

	JSONArray createPerson(PersonCreate dto);
	
	JSONObject getPerson(String firstName, String lastName);
	
	JSONObject updatePerson(String firstName, String lastName);
	
	JSONObject deletePerson(String firstName, String lastName);
}
