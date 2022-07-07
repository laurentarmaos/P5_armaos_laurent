package com.safetynet.safetynetalert.dao;

import org.json.simple.JSONArray;


public interface InfoDao {

	JSONArray getPerson();
	
	JSONArray getMedic();
	
	JSONArray getFireStation();
		
}
