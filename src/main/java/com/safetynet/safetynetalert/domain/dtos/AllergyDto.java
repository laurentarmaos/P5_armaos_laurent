package com.safetynet.safetynetalert.domain.dtos;


public class AllergyDto {

	private String allergyName;

	
	public AllergyDto() {
		
	}

	public String getAllergyName() {
		return allergyName;
	}

	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}


	@Override
	public String toString() {
		return "AllergyDto [allergyName=" + allergyName + "]";
	}
	
	

}
