package com.safetynet.safetynetalert.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.dao.InfoDao;
import com.safetynet.safetynetalert.domain.dtos.CommunityEmailDto;
import com.safetynet.safetynetalert.domain.dtos.PersonDto;

@Service
public class CommunityEmailServiceImpl implements CommunityEmailService{
	
private final InfoDao personInfoDao;
	
	public CommunityEmailServiceImpl(InfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}
	
	List<Object> result;

	@Override
	public List<Object> emailCity(String city) {

		result = new ArrayList<Object>();

		for(int i = 0; i < personInfoDao.getPerson().size(); i++) {
			
			JSONObject jsonPerson = (JSONObject) personInfoDao.getPerson().get(i);
			
			PersonDto person = new PersonDto();
			person.setEmail((String) jsonPerson.get("email"));
			
			if(city.equals(jsonPerson.get("city"))) {
				result.add(new CommunityEmailDto(person.getEmail()));
			}else {
				System.out.println("no email address in city " + city);
				break;
			}
		}
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		System.out.println(jsonString);
		return result;
	}
}
