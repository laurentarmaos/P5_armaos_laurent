package com.safetynet.safetynetalert.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalert.domain.dtos.MedicalRecordsCreate;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

	@Override
	public JSONArray createMedicalRecord(MedicalRecordsCreate dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public JSONObject getMedicalRecord(String firstName, String lastName) {
		return null;
	}

	@Override
	public JSONObject updateMedicalRecord(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject deleteMedicalRecord(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
