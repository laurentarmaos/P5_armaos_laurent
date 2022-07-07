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
import com.safetynet.safetynetalert.domain.dtos.FireStationDto;
import com.safetynet.safetynetalert.domain.dtos.MedicationDto;
import com.safetynet.safetynetalert.domain.dtos.PersonDto;

@Service
public class StationsPersonsInfosServiceImpl implements StationsPersonsInfosService {

	private final InfoDao infoDao;	
	
	public StationsPersonsInfosServiceImpl(InfoDao infoDao) {
		this.infoDao = infoDao;
	}

	List<Object> result = new ArrayList<Object>();

	@Override
	public List<Object> stationPersonsInfo(String fireStationNubmer) {

		PersonDto person = new PersonDto();
		FireStationDto fireStation = new FireStationDto();
		AllergyDto allergy = new AllergyDto();
		MedicationDto medication = new MedicationDto();
		
		
		for(int i = 0; i < infoDao.getFireStation().size(); i++) {
			
			JSONObject jsonFireStation = (JSONObject) infoDao.getFireStation().get(i);
			
			if(jsonFireStation.get("station").equals(fireStationNubmer)) {
				fireStation.setAddress( (String) jsonFireStation.get("address") );
				result.add(new FireStationDto(fireStation.getAddress()));
				
				
				for(int j = 0; j < infoDao.getPerson().size(); j++) {
					JSONObject jsonPerson = (JSONObject) infoDao.getPerson().get(j);
					
					if(jsonPerson.get("address").equals(fireStation.getAddress())) {
						
						for(int k = 0; k < infoDao.getMedic().size(); k++) {
							
							JSONObject jsonMedic = (JSONObject) infoDao.getMedic().get(k);
							
							if(jsonPerson.get("firstName").equals(jsonMedic.get("firstName")) && jsonPerson.get("lastName").equals(jsonMedic.get("lastName"))) {
								person.setFirstName((String) jsonPerson.get("firstName"));
								person.setLastName((String) jsonPerson.get("lastName"));
								person.setPhone((String) jsonPerson.get("phone"));
								
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
								
								result.add(new PersonDto(person.getFirstName(), person.getLastName(), person.getPhone(), person.getAge(), person.getMedications(), person.getAllergies()));
							}
						}
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
