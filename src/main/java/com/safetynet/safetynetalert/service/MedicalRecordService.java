package com.safetynet.safetynetalert.service;

import com.safetynet.safetynetalert.domain.dtos.MedicationDto;

public interface MedicalRecordService {
	
	MedicationDto createMedicalRecord();
	
	MedicationDto updateMedicalRecord(String firstName, String lastName);
	
	MedicationDto deleteMedicalRecord(String firstName, String lastName);

}
