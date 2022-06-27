package com.safetynet.safetynetalert.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalert.dao.PersonInfoDao;
import com.safetynet.safetynetalert.domain.dtos.PersonDto;

@Service
public class CommunityEmailServiceImpl implements CommunityEmailService{
	
private final PersonInfoDao personInfoDao;
	
	public CommunityEmailServiceImpl(PersonInfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}
	

	@Override
	public void emailCity(String city) {


		for(int i = 0; i < personInfoDao.getPerson().size(); i++) {
			
			JSONObject jsonPerson = (JSONObject) personInfoDao.getPerson().get(i);
			
			PersonDto person = new PersonDto();
			person.setEmail((String) jsonPerson.get("email"));
			
			if(city.equals(jsonPerson.get("city"))) {
				System.out.println(person.getEmail());
			}else {
				System.out.println("no email address in city " + city);
				break;
			}
		}
		
	}

}
