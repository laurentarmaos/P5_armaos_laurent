package com.safetynet.safetynetalert.daos;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class PersonInfoDao {

	public void readJsonDatas(){
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("data.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray persons = (JSONArray) jsonObject.get("persons");
			JSONArray medicalRecords = (JSONArray) jsonObject.get("medicalrecords");
			
			
			JSONObject jsonPerson = (JSONObject) persons.get(0);
			JSONObject jsonMedic = (JSONObject) medicalRecords.get(0);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
