package com.safetynet.safetynetalert.controllers;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalert.model.Allergy;
import com.safetynet.safetynetalert.model.Medication;
import com.safetynet.safetynetalert.model.Person;

@RestController
@RequestMapping("/personInfo")
public class PersonInfoController {

	@GetMapping
	public @ResponseBody void personInfo(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		
		
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
				
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				String dateString = (String) jsonMedic.get("birthdate");
				Date birthDate = formatter.parse(dateString);
				
				person.setBirthDate(birthDate);
				person.setEmail((String) jsonPerson.get("email"));
				
				
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


				if(firstName.equalsIgnoreCase(person.getFirstName()) && lastName.equalsIgnoreCase(person.getLastName())) {
					Date date = new Date();
					System.out.println("Prénom : " + person.getFirstName() + ", Nom : " + person.getLastName() + ", Age : " + Math.ceil((date.getTime() - person.getBirthDate().getTime())/(86400 * 1000 * 365.24)) + ", Adresse : " + person.getAddress() + ", Email : " + person.getEmail()  + ", Médicaments : " + person.getMedications() + ", Allergies : " + person.getAllergies());
				}

			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
