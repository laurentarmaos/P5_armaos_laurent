package com.safetynet.safetynetalert.service;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalert.dao.InfoDao;
import com.safetynet.safetynetalert.domain.dtos.PersonCreate;

@Service
public class PersonServiceImpl implements PersonService {
	
	private final InfoDao infoDao;
	
	public PersonServiceImpl(InfoDao infoDao) {
		this.infoDao = infoDao;
	}
	
	
	@Override
	public JSONArray createPerson(PersonCreate dto) {
				
		PersonCreate entity = new PersonCreate();
		
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setAddress(dto.getAddress());
		entity.setCity(dto.getCity());
		entity.setZip(dto.getZip());
		entity.setPhone(dto.getPhone());
		entity.setEmail(dto.getEmail());
		
		
		JSONArray persons = infoDao.getPerson();
		
		persons.add(entity);
		
		
		System.out.println(persons);
		return persons;
		
		
	}
	
	@Override
	public JSONObject getPerson(String firstName, String lastName) {
		
		for(int i = 0; i < infoDao.getPerson().size(); i++) {
			
			JSONObject jsonPerson = (JSONObject) infoDao.getPerson().get(i);
			
			if(jsonPerson.get("firstName").equals(firstName) && jsonPerson.get("lastName").equals(lastName)) {
				JSONObject getJsonPerson = (JSONObject) jsonPerson;
				
				System.out.println(getJsonPerson);
				return getJsonPerson;
			}
		}
		
		return null;
	}

	@Override
	public JSONArray updatePerson(String firstName, String lastName, PersonCreate dto) {
		
		PersonCreate entity = new PersonCreate();
		
		for(int i = 0; i < infoDao.getPerson().size(); i++) {
			
			JSONArray persons = infoDao.getPerson();
			JSONObject jsonPerson = (JSONObject) infoDao.getPerson().get(i);
			
			if(jsonPerson.get("firstName").equals(firstName) && jsonPerson.get("lastName").equals(lastName)) {
				JSONObject getJsonPerson = (JSONObject) jsonPerson;

				entity.setAddress(dto.getAddress());
				entity.setCity(dto.getCity());
				entity.setZip(dto.getZip());
				entity.setPhone(dto.getPhone());
				entity.setEmail(dto.getEmail());
				
				getJsonPerson.put("address", entity.getAddress());
				getJsonPerson.put("city", entity.getCity());
				getJsonPerson.put("zip", entity.getZip());
				getJsonPerson.put("phone", entity.getPhone());
				getJsonPerson.put("email", entity.getEmail());
				
				persons.remove(i);
				persons.add(i, getJsonPerson);
				
				System.out.println(persons);
				return persons;
			}
		}
		return null;
	}

	@Override
	public JSONArray deletePerson(String firstName, String lastName) {

		for(int i = 0; i < infoDao.getPerson().size(); i++) {
			
			JSONArray persons = infoDao.getPerson();
			JSONObject jsonPerson = (JSONObject) infoDao.getPerson().get(i);
			
			if(jsonPerson.get("firstName").equals(firstName) && jsonPerson.get("lastName").equals(lastName)) {
				
				persons.remove(i);
				
				System.out.println(persons);
				return persons;
			}
		}
		return null;
	}

}
