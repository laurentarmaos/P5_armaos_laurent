package com.safetynet.safetynetalert.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalert.dao.PersonInfoDao;
import com.safetynet.safetynetalert.domain.dtos.PersonDto;



@Service
public class ChildAlertServiceImpl implements ChildAlertService {
	
	private final PersonInfoDao personInfoDao;
	

	public ChildAlertServiceImpl(PersonInfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}


	@Override
	public void childAlert(String address) {

		Set<String> family = new HashSet<String>();
		Set<String> child = new HashSet<String>();
		
		for(int i = 0; i < personInfoDao.getPerson().size(); i++) {
						
			JSONObject jsonPerson = (JSONObject) personInfoDao.getPerson().get(i);
			
			
			for(int j = 0; j < personInfoDao.getMedic().size(); j++) {
				
				JSONObject jsonMedic = (JSONObject) personInfoDao.getMedic().get(j);
				
				if( jsonPerson.get("firstName").equals(jsonMedic.get("firstName")) && jsonPerson.get("lastName").equals(jsonMedic.get("lastName")) && jsonPerson.get("address").equals(address)) {
					
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
					
					Date date = new Date();
					
					
					
					if(Math.ceil((date.getTime() - person.getBirthDate().getTime())/(86400 * 1000 * 365.24)) > 18) {
						family.add(person.getFirstName() + " " + person.getLastName());
					}
					
					if(Math.ceil((date.getTime() - person.getBirthDate().getTime())/(86400 * 1000 * 365.24)) < 18) {
						child.add(person.getFirstName() + " " + person.getLastName() + " " + Math.ceil((date.getTime() - person.getBirthDate().getTime())/(86400 * 1000 * 365.24)) + " ans");
					}
					
				}
			}
	
		}
		
		if(child.size() != 0) {		
			System.out.println( "enfants : " + child + ", autres membres de la famille : " + family);
		}
		
	}

}
