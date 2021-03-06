package com.safetynet.safetynetalert.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.safetynet.safetynetalert.domain.dtos.MedicalRecordsCreate;

public interface MedicalRecordService {
	
	JSONArray createMedicalRecord(MedicalRecordsCreate dto);
	
	JSONObject getMedicalRecord (String firstName, String lastName);
	
	JSONArray updateMedicalRecord(String firstName, String lastName, MedicalRecordsCreate dto);
	
	JSONArray deleteMedicalRecord(String firstName, String lastName);

}
