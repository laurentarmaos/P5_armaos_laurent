package com.safetynet.safetynetalert.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.dao.InfoDao;
import com.safetynet.safetynetalert.domain.dtos.FireStationDto;
import com.safetynet.safetynetalert.domain.dtos.FireStationPersonsInfosDto;
import com.safetynet.safetynetalert.domain.dtos.PersonDto;

@Service
public class FireStationPersonsInfosServiceImpl implements FireStationPersonsInfosService{
	
	private final InfoDao infoDao;

	public FireStationPersonsInfosServiceImpl(InfoDao infoDao) {
		this.infoDao = infoDao;
	}


	List<Object> result;
	
	
	@Override
	public List<Object> fireStationPersonsInfos(String fireStationNumber) {
		
		result = new ArrayList<Object>();

		PersonDto person = new PersonDto();
		FireStationDto fireStation = new FireStationDto();
		int child = 0;
		int adult = 0;
		
		for(int i = 0; i < infoDao.getFireStation().size(); i++) {
			
			JSONObject jsonFireStation = (JSONObject) infoDao.getFireStation().get(i);
			
			if(jsonFireStation.get("station").equals(fireStationNumber)) {
				fireStation.setAddress( (String) jsonFireStation.get("address") );
				
				for(int j = 0; j < infoDao.getPerson().size(); j++) {
					JSONObject jsonPerson = (JSONObject) infoDao.getPerson().get(j);
					
					if(jsonPerson.get("address").equals(fireStation.getAddress())) {
						
						for(int k = 0; k < infoDao.getMedic().size(); k++) {
							
							JSONObject jsonMedic = (JSONObject) infoDao.getMedic().get(k);
							
							if(jsonPerson.get("firstName").equals(jsonMedic.get("firstName")) && jsonPerson.get("lastName").equals(jsonMedic.get("lastName"))) {
								
								person.setFirstName((String) jsonPerson.get("firstName"));
								person.setLastName((String) jsonPerson.get("lastName"));
								person.setAddress((String) jsonPerson.get("address"));
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
								double age = Math.ceil((date.getTime() - person.getBirthDate().getTime())/(86400 * 1000 * 365.24));
								
								if(age < 18) {
									child++;
								}else {
									adult++;
								}
												
								result.add(new FireStationPersonsInfosDto(person.getFirstName(), person.getLastName(), person.getAddress(), person.getPhone()));
							}
						}
					}
				}
			}
		}
		
		result.addAll(Arrays.asList("childs : " + child, " adults : " + adult));
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		System.out.println(jsonString);
		return result;
	}

}
