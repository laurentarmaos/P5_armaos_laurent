package com.safetynet.safetynetalert.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.dao.InfoDao;
import com.safetynet.safetynetalert.domain.dtos.AllergyDto;
import com.safetynet.safetynetalert.domain.dtos.MedicationDto;
import com.safetynet.safetynetalert.domain.dtos.PersonDto;



@Service
public class PersonInfoServiceImpl implements PersonInfoService{

	private final InfoDao infoDao;
	
	public PersonInfoServiceImpl(InfoDao infoDao) {
		this.infoDao = infoDao;
	}

	List<Object> result = new ArrayList<Object>();
	
	@Override
	public List<Object> personInfo(String firstName, String lastName) {

		for(int i = 0; i < infoDao.getPerson().size(); i++) {
					
			JSONObject jsonPerson = (JSONObject) infoDao.getPerson().get(i);
			
			for(int k = 0; k < infoDao.getMedic().size(); k++) {
				JSONObject jsonMedic = (JSONObject) infoDao.getMedic().get(k);
				
				if( jsonPerson.get("firstName").equals(jsonMedic.get("firstName")) && jsonPerson.get("lastName").equals(jsonMedic.get("lastName")) ) {
					
					// création des objets dto
					AllergyDto allergy = new AllergyDto();
					MedicationDto medication = new MedicationDto();
					PersonDto person = new PersonDto();
					
					person.setFirstName((String) jsonPerson.get("firstName"));
					person.setLastName((String) jsonPerson.get("lastName"));
					person.setAddress((String) jsonPerson.get("address"));
					person.setCity((String) jsonPerson.get("city"));
					person.setPhone((String) jsonPerson.get("phone"));
					person.setZipCode((String) jsonPerson.get("zip"));
					person.setEmail((String) jsonPerson.get("email"));
					
					SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					String dateString = (String) jsonMedic.get("birthdate");
					Date birthDate;
					try {
						birthDate = formatter.parse(dateString);
						person.setBirthDate(birthDate);
					} catch (ParseException e) {
						e.printStackTrace();
					}
							
					Date date = new Date();
					person.setAge(Math.ceil((date.getTime() - person.getBirthDate().getTime())/(86400 * 1000 * 365.24)));
					
					JSONArray medic = (JSONArray) jsonMedic.get("medications");
					JSONArray allerg = (JSONArray) jsonMedic.get("allergies");
				
					Set<String> medicList = new HashSet<String>();
					for(int j = 0; j < medic.size(); j++) {
							
						medication.setMedicationName((String) medic.get(j));
						medicList.add(medication.getMedicationName());
					}
					person.setMedications(medicList);
					
					
					Set<String> allergList = new HashSet<String>();
					for(int j = 0; j < allerg.size(); j++) {
						allergy.setAllergyName((String) allerg.get(j));
						allergList.add(allergy.getAllergyName());
					}		
					person.setAllergies(allergList);


					if(firstName.equalsIgnoreCase(person.getFirstName()) && lastName.equalsIgnoreCase(person.getLastName())) {
						
						result.add(new PersonDto(person.getFirstName(), person.getLastName(), person.getAddress(), person.getEmail(), person.getAge(), person.getAllergies(), person.getMedications()));
					}			
				}
			}
		}
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		System.out.println(jsonString);
		return result;
	}	
}
