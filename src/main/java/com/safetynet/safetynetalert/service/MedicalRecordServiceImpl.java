package com.safetynet.safetynetalert.service;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalert.dao.InfoDao;
import com.safetynet.safetynetalert.domain.dtos.MedicalRecordsCreate;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
	
	private final InfoDao infoDao;
	

	public MedicalRecordServiceImpl(InfoDao infoDao) {
		this.infoDao = infoDao;
	}

	@Override
	public JSONArray createMedicalRecord(MedicalRecordsCreate dto) {

		MedicalRecordsCreate entity = new MedicalRecordsCreate();
		
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());	
		entity.setBirthdate(dto.getBirthdate());	
		entity.setMedications(dto.getMedications());
		entity.setAllergies(dto.getAllergies());
		
		JSONArray medication = infoDao.getMedic();
		
		medication.add(entity);
		
		System.out.println(medication);
		return medication;
	}
	
	@Override
	public JSONObject getMedicalRecord(String firstName, String lastName) {
		
		for(int i = 0; i < infoDao.getMedic().size(); i++) {
			
			JSONObject jsonMedic = (JSONObject) infoDao.getMedic().get(i);
			
			if(jsonMedic.get("firstName").equals(firstName) && jsonMedic.get("lastName").equals(lastName)) {
				
				JSONObject getJsonMedic = (JSONObject) jsonMedic;
				
				System.out.println(getJsonMedic);
				return getJsonMedic;
			}
		}
		return null;
	}

	@Override
	public JSONArray updateMedicalRecord(String firstName, String lastName, MedicalRecordsCreate dto) {
		
		MedicalRecordsCreate entity = new MedicalRecordsCreate();
		
		for(int i = 0; i < infoDao.getMedic().size(); i++) {
			
			JSONArray medication = infoDao.getMedic();
			JSONObject jsonMedic = (JSONObject) infoDao.getMedic().get(i);
			
			if(jsonMedic.get("firstName").equals(firstName) && jsonMedic.get("lastName").equals(lastName)) {
				JSONObject getJsonMedic = (JSONObject) jsonMedic;
				
				entity.setBirthdate(dto.getBirthdate());	
				entity.setMedications(dto.getMedications());
				entity.setAllergies(dto.getAllergies());
				
				getJsonMedic.put("birthdate", dto.getBirthdate());
				getJsonMedic.put("medications", dto.getMedications());
				getJsonMedic.put("allergies", dto.getAllergies());
				
				medication.remove(i);
				medication.add(i, getJsonMedic);
				
				System.out.println(medication);
				return medication;
			}
			
		}
		return null;
	}

	@Override
	public JSONArray deleteMedicalRecord(String firstName, String lastName) {

		for(int i = 0; i < infoDao.getMedic().size(); i++) {
			
			JSONArray medication = infoDao.getMedic();
			JSONObject jsonMedic = (JSONObject) infoDao.getMedic().get(i);
			
			if(jsonMedic.get("firstName").equals(firstName) && jsonMedic.get("lastName").equals(lastName)) {

				medication.remove(i);
				
				System.out.println(medication);
				return medication;
			}
			
		}
		return null;
	}

}
