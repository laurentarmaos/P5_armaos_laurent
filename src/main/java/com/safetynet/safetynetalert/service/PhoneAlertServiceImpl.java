package com.safetynet.safetynetalert.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalert.dao.PersonInfoDao;
import com.safetynet.safetynetalert.domain.dtos.PersonDto;

@Service
public class PhoneAlertServiceImpl implements PhoneAlertService{

	private final PersonInfoDao personInfoDao;
	
	public PhoneAlertServiceImpl(PersonInfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}
	
	@Override
	public void alert(String fireStationNubmer) {

		for(int i = 0; i < personInfoDao.getFireStation().size(); i++) {
			
			JSONObject jsonFireStation = (JSONObject) personInfoDao.getFireStation().get(i);
			
			
			for(int j = 0; j < personInfoDao.getPerson().size(); j++) {
				
				JSONObject jsonPerson = (JSONObject) personInfoDao.getPerson().get(j);
				
				PersonDto person = new PersonDto();
				
				if(jsonFireStation.get("address").equals(jsonPerson.get("address")) && jsonFireStation.get("station").equals(fireStationNubmer)) {
					
					person.setPhone((String) jsonPerson.get("phone"));
					
					System.out.println(person.getPhone());
				}
				
			}
			
		}	
		
	}

}
