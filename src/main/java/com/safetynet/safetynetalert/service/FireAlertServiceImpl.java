package com.safetynet.safetynetalert.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalert.dao.PersonInfoDao;
import com.safetynet.safetynetalert.domain.dtos.PersonDto;

@Service
public class FireAlertServiceImpl implements FireAlertService{

	private final PersonInfoDao personInfoDao;
	

	public FireAlertServiceImpl(PersonInfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}


	@Override
	public void fireAlert(String address) {


		for(int i = 0; i < personInfoDao.getPerson().size(); i++) {
			
			JSONObject jsonPerson = (JSONObject) personInfoDao.getPerson().get(i);
			
			
			for(int j = 0; j < personInfoDao.getFireStation().size(); j++) {
				
				JSONObject jsonFireStation = (JSONObject) personInfoDao.getFireStation().get(j);
				
				PersonDto person = new PersonDto();
				
				
			}
		}
		
	}

}
