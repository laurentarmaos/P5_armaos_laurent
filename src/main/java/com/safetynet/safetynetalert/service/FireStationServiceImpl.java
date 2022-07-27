package com.safetynet.safetynetalert.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalert.dao.InfoDao;
import com.safetynet.safetynetalert.domain.dtos.FireStationDto;

@Service
public class FireStationServiceImpl implements FireStationService{
	
	
	private final InfoDao infoDao;
	
	public FireStationServiceImpl(InfoDao infoDao) {
		this.infoDao = infoDao;
	}

	@Override
	public JSONArray createFireStation(FireStationDto dto) {

		FireStationDto entity = new FireStationDto();
		
		entity.setAddress(dto.getAddress());
		entity.setStation(dto.getStation());
		
		JSONArray firestations = infoDao.getFireStation();
		
		firestations.add(entity);
		
		System.out.println(firestations);
		return firestations;
	}

	@Override
	public JSONObject getFireStation(String address) {

		for(int i = 0; i < infoDao.getFireStation().size(); i++) {
			
			JSONObject jsonFireStation = (JSONObject) infoDao.getFireStation().get(i);
			
			if(jsonFireStation.get("address").equals(address)) {
				JSONObject getJsonFireStation = (JSONObject) jsonFireStation;
				
				System.out.println(getJsonFireStation);
				return getJsonFireStation;
			}
		}
		
		return null;
	}

	@Override
	public JSONArray updateFireStation(String address, FireStationDto dto) {
		
		FireStationDto entity = new FireStationDto();
		
		for(int i = 0; i < infoDao.getFireStation().size(); i++) {
			
			JSONArray firestations = infoDao.getFireStation();
			JSONObject jsonFireStation = (JSONObject) infoDao.getFireStation().get(i);
			
			if(jsonFireStation.get("address").equals(address)) {
				JSONObject getJsonFireStation = (JSONObject) jsonFireStation;
				
				entity.setStation(dto.getStation());

				getJsonFireStation.put("station", entity.getStation());
				
				firestations.remove(i);
				firestations.add(i, getJsonFireStation);
				
				System.out.println(firestations);
				return firestations;
			}
		}
		return null;
	}

	@Override
	public JSONArray deleteFireStation(String address) {
		
		for(int i = 0; i < infoDao.getFireStation().size(); i++) {
			
			JSONArray firestations = infoDao.getFireStation();
			JSONObject jsonFireStation = (JSONObject) infoDao.getFireStation().get(i);
			
			if(jsonFireStation.get("address").equals(address)) {

				firestations.remove(i);
				
				System.out.println(firestations);
				return firestations;
			}
		}

		return null;
	}
}
