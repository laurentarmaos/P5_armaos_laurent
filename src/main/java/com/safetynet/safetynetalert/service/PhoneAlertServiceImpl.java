package com.safetynet.safetynetalert.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.dao.InfoDao;
import com.safetynet.safetynetalert.domain.dtos.PersonDto;
import com.safetynet.safetynetalert.domain.dtos.PhoneAlertDto;

@Service
public class PhoneAlertServiceImpl implements PhoneAlertService{

	private final InfoDao personInfoDao;
	
	public PhoneAlertServiceImpl(InfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}
	
	List<Object> result;
	
	@Override
	public List<Object> alert(String fireStationNubmer) {
		
		result  = new ArrayList<Object>();

		for(int i = 0; i < personInfoDao.getFireStation().size(); i++) {
			
			JSONObject jsonFireStation = (JSONObject) personInfoDao.getFireStation().get(i);
			
			
			for(int j = 0; j < personInfoDao.getPerson().size(); j++) {
				
				JSONObject jsonPerson = (JSONObject) personInfoDao.getPerson().get(j);
				
				PersonDto person = new PersonDto();
				
				if(jsonFireStation.get("address").equals(jsonPerson.get("address")) && jsonFireStation.get("station").equals(fireStationNubmer)) {
					
					person.setPhone((String) jsonPerson.get("phone"));
					
					result.add(new PhoneAlertDto(person.getPhone()));
					System.out.println(person.getPhone());
				}
				
			}
			
		}	
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		System.out.println(jsonString);
		return result;
		
	}

}
