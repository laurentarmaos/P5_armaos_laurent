package com.safetynet.safetynetalert.dao;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Repository;

@Repository
public class PersonInfoDaoImpl implements PersonInfoDao{
	

	 private final DaoFactory daoFactory = new DaoFactory();
	

	@Override
	public JSONArray getPerson() {
		
		JSONArray persons = (JSONArray) daoFactory.connectToJson().get("persons");
		
		return persons;
	}

	@Override
	public JSONArray getMedic() {
		
		JSONArray medicalRecords = (JSONArray) daoFactory.connectToJson().get("medicalrecords");
		
		return medicalRecords;
	}
	
	@Override
	public JSONArray getFireStation() {
		
	JSONArray fireStation = (JSONArray) daoFactory.connectToJson().get("firestations");
	
	return fireStation;
	
	}

}
