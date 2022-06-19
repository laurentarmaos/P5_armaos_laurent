package com.safetynet.safetynetalert.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalert.daos.PersonInfoDao;
import com.safetynet.safetynetalert.domain.Allergy;
import com.safetynet.safetynetalert.domain.Medication;
import com.safetynet.safetynetalert.domain.Person;



@Service
public class PersonInfoServiceImpl implements PersonInfoService{

	private final PersonInfoDao personInfoDao;
	
	public PersonInfoServiceImpl(PersonInfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}

	
	
	@Override
	public void personInfo(String firstName, String lastName) {


		for(int i = 0; i < personInfoDao.getPerson().size(); i++) {
			
			
			JSONObject jsonPerson = (JSONObject) personInfoDao.getPerson().get(i);
			JSONObject jsonMedic = (JSONObject) personInfoDao.getMedic().get(i);
				
			
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
			Date birthDate;
			try {
				birthDate = formatter.parse(dateString);
				person.setBirthDate(birthDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
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
		
	}
	
	
	
}
