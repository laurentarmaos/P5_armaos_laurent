package com.safetynet.safetynetalert.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.dao.InfoDao;
import com.safetynet.safetynetalert.domain.dtos.PersonDto;



@Service
public class ChildAlertServiceImpl implements ChildAlertService {
	
	private final InfoDao personInfoDao;
	

	public ChildAlertServiceImpl(InfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}


	List<Object> result = new ArrayList<Object>();
	
	@Override
	public List<Object> childAlert(String address) {

		Set<String> child = new HashSet<String>();
		
		for(int i = 0; i < personInfoDao.getPerson().size(); i++) {
						
			JSONObject jsonPerson = (JSONObject) personInfoDao.getPerson().get(i);
			
			
			for(int j = 0; j < personInfoDao.getMedic().size(); j++) {
				
				JSONObject jsonMedic = (JSONObject) personInfoDao.getMedic().get(j);
				
				if( jsonPerson.get("firstName").equals(jsonMedic.get("firstName")) && jsonPerson.get("lastName").equals(jsonMedic.get("lastName")) && jsonPerson.get("address").equals(address)) {
					
					Date date = new Date();
					PersonDto person = new PersonDto();
					
					person.setFirstName((String) jsonPerson.get("firstName"));
					person.setLastName((String) jsonPerson.get("lastName"));
					
					SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					String dateString = (String) jsonMedic.get("birthdate");
					Date birthDate;
					try {
						birthDate = formatter.parse(dateString);
						person.setBirthDate(birthDate);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					person.setAge(Math.ceil((date.getTime() - person.getBirthDate().getTime())/(86400 * 1000 * 365.24)));
					
					if(person.getAge() > 18) {
						result.add(new PersonDto(person.getFirstName(), person.getLastName()));
					}
					
					if(person.getAge() < 18) {
						child.add("");
						result.add(new PersonDto(person.getFirstName(), person.getLastName(), person.getAge()));
					}
					
				}
			}
	
		}
		
		if(child.size() != 0) {		
			Gson gson = new Gson();
			String jsonString = gson.toJson(result);
			System.out.println(jsonString);
			return result;
		}else {
			return null;
		}
		
	}

}
