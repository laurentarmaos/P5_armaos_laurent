package com.safetynet.safetynetalert.dao;

import org.json.simple.JSONArray;


public interface PersonInfoDao {

	JSONArray getPerson();
	
	JSONArray getMedic();
	
	JSONArray getFireStation();
		
}
