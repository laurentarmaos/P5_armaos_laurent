package com.safetynet.safetynetalert.controller;

import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalert.model.Allergy;
import com.safetynet.safetynetalert.model.Medication;
import com.safetynet.safetynetalert.model.Person;


@RestController
@RequestMapping("/test")
public class Test {

	
	@GetMapping("/read")
	public void readJson() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("data.json"));
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray persons = (JSONArray) jsonObject.get("persons");
			JSONArray medicalRecords = (JSONArray) jsonObject.get("medicalrecords");

			
			for(int i = 0; i < persons.size(); i++) {
				
				JSONObject jsonPerson = (JSONObject) persons.get(i);
				JSONObject jsonMedic = (JSONObject) medicalRecords.get(i);
				
				
				Allergy allergy = new Allergy();
				Medication medication = new Medication();
				Person person = new Person();
				
				
				person.setFirstName((String) jsonPerson.get("firstName"));
				person.setLastName((String) jsonPerson.get("lastName"));
				person.setAddress((String) jsonPerson.get("address"));
				person.setCity((String) jsonPerson.get("city"));
				person.setPhone((String) jsonPerson.get("phone"));
				person.setZipCode((String) jsonPerson.get("zip"));
				person.setBirthDate((String) jsonMedic.get("birthdate"));
				person.setEmail((String) jsonMedic.get("email"));
				
				
				JSONArray medic = (JSONArray) jsonMedic.get("medications");
				JSONArray allerg = (JSONArray) jsonMedic.get("allergies");
				
				
				Set<Medication> medicList = new HashSet<Medication>();
				for(int j = 0; j < medic.size(); j++) {
					medication.setMedicationName((String) medic.get(j));
					medicList.add(medication);
				}
				person.setMedications(medicList);
				
				
				Set<Allergy> allergList = new HashSet<Allergy>();
				for(int j = 0; j < allerg.size(); j++) {
					allergy.setAllergyName((String) allerg.get(j));
					allergList.add(allergy);
				}		
				person.setAllergies(allergList);
				
				System.out.println(person.toString());
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   
}
