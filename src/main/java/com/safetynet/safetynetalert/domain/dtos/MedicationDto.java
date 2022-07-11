package com.safetynet.safetynetalert.domain.dtos;


public class MedicationDto {

	private String medicationName;

	
	public MedicationDto() {}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	@Override
	public String toString() {
		return "MedicationDto [medicationName=" + medicationName + "]";
	}

	
}
