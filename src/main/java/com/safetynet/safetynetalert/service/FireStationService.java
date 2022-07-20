package com.safetynet.safetynetalert.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.safetynet.safetynetalert.domain.dtos.FireStationDto;

public interface FireStationService {

	JSONArray createFireStation(FireStationDto dto);
	
	JSONObject getFireStation(String address);
	
	JSONObject updateFireStation(String address);
	
	JSONObject deleteFireStation(String address);
}
