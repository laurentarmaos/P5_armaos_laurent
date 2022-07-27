package com.safetynet.safetynetalert.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.safetynet.safetynetalert.domain.dtos.FireStationDto;

public interface FireStationService {

	JSONArray createFireStation(FireStationDto dto);
	
	JSONObject getFireStation(String address);
	
	JSONArray updateFireStation(String address, FireStationDto dto);
	
	JSONArray deleteFireStation(String address);
}
