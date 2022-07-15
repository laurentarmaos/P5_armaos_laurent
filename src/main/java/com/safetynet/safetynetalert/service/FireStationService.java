package com.safetynet.safetynetalert.service;

import com.safetynet.safetynetalert.domain.dtos.FireStationDto;

public interface FireStationService {

	FireStationDto createFireStation();
	
	FireStationDto updateFireStation(String address);
	
	FireStationDto deleteFireStation(String address);
}
