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
import com.safetynet.safetynetalert.domain.dtos.FireAlertDto;
import com.safetynet.safetynetalert.domain.dtos.FireStationDto;
import com.safetynet.safetynetalert.domain.dtos.MedicationDto;
import com.safetynet.safetynetalert.domain.dtos.PersonDto;

@Service
public class FireAlertServiceImpl implements FireAlertService{

	private final InfoDao infoDao;
	

	public FireAlertServiceImpl(InfoDao infoDao) {
		this.infoDao = infoDao;
	}

	List<Object> result;
	
	@Override
	public List<Object> fireAlert(String address) {
		
		result = new ArrayList<Object>();

		PersonDto person = new PersonDto();
		FireStationDto fireStation = new FireStationDto();
		AllergyDto allergy = new AllergyDto();
		MedicationDto medication = new MedicationDto();

		
		for(int i = 0; i < infoDao.getPerson().size(); i++) {
					
			JSONObject jsonPerson = (JSONObject) infoDao.getPerson().get(i);			
			
			for(int j = 0; j < infoDao.getFireStation().size(); j++) {
				
				JSONObject jsonFireStation = (JSONObject) infoDao.getFireStation().get(j);			
				
				if(jsonPerson.get("address").equals(jsonFireStation.get("address")) && jsonPerson.get("address").equals(address) ) {
				
					fireStation.setStation( (String) jsonFireStation.get("station") );
				}
			}
		}	
		
		result.add(new FireStationDto(address, fireStation.getStation()));
		
		for(int i = 0; i < infoDao.getPerson().size(); i++) {
			
			JSONObject jsonPerson = (JSONObject) infoDao.getPerson().get(i);			

			for(int k = 0; k < infoDao.getMedic().size(); k++) {
				
				JSONObject jsonMedic = (JSONObject) infoDao.getMedic().get(k);
				if(jsonPerson.get("firstName").equals(jsonMedic.get("firstName")) && jsonPerson.get("lastName").equals(jsonMedic.get("lastName")) && jsonPerson.get("address").equals(address)) {
					
					person.setFirstName( (String) jsonPerson.get("firstName") );
					person.setLastName( (String) jsonPerson.get("lastName") );
					person.setPhone( (String) jsonPerson.get("phone") );
					
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
					for(int l = 0; l < medic.size(); l++) {
							
						medication.setMedicationName((String) medic.get(l));
						medicList.add(medication.getMedicationName());
					}
					person.setMedications(medicList);
					
					
					Set<String> allergList = new HashSet<String>();
					for(int l = 0; l < allerg.size(); l++) {
						allergy.setAllergyName((String) allerg.get(l));
						allergList.add(allergy.getAllergyName());
					}		
					person.setAllergies(allergList);
					
					
					result.add(new FireAlertDto(person.getFirstName(), person.getLastName(), person.getPhone(), person.getAge(), person.getMedications(), person.getAllergies()));
					
				}	
			}		
		}	
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		System.out.println(jsonString);
		return result;
	}
}
