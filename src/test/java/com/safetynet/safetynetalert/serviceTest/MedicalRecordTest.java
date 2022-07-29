package com.safetynet.safetynetalert.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.domain.dtos.MedicalRecordsCreate;
import com.safetynet.safetynetalert.service.MedicalRecordService;

@SpringBootTest
public class MedicalRecordTest {
	
	@Autowired
	private MedicalRecordService medicalRecord;
	
	@Test
	public void createMedicalRecordTest() {
		
		String excepted = "[{\"allergies\":[\"nillacilan\"],\"firstName\":\"John\",\"lastName\":\"Boyd\",\"birthdate\":\"03/06/1984\",\"medications\":[\"aznol:350mg\",\"hydrapermazol:100mg\"]},{\"allergies\":[],\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"birthdate\":\"03/06/1989\",\"medications\":[\"pharmacol:5000mg\",\"terazine:10mg\",\"noznazol:250mg\"]},{\"allergies\":[\"peanut\"],\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"birthdate\":\"02/18/2012\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"birthdate\":\"09/06/2017\",\"medications\":[]},{\"allergies\":[\"xilliathal\"],\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"birthdate\":\"01/08/1986\",\"medications\":[\"tetracyclaz:650mg\"]},{\"allergies\":[],\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"birthdate\":\"01/03/1989\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Tessa\",\"lastName\":\"Carman\",\"birthdate\":\"02/18/2012\",\"medications\":[]},{\"allergies\":[\"shellfish\"],\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"birthdate\":\"09/06/2000\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Foster\",\"lastName\":\"Shepard\",\"birthdate\":\"01/08/1980\",\"medications\":[]},{\"allergies\":[\"shellfish\"],\"firstName\":\"Tony\",\"lastName\":\"Cooper\",\"birthdate\":\"03/06/1994\",\"medications\":[\"hydrapermazol:300mg\",\"dodoxadin:30mg\"]},{\"allergies\":[],\"firstName\":\"Lily\",\"lastName\":\"Cooper\",\"birthdate\":\"03/06/1994\",\"medications\":[]},{\"allergies\":[\"peanut\",\"shellfish\",\"aznol\"],\"firstName\":\"Sophia\",\"lastName\":\"Zemicks\",\"birthdate\":\"03/06/1988\",\"medications\":[\"aznol:60mg\",\"hydrapermazol:900mg\",\"pharmacol:5000mg\",\"terazine:500mg\"]},{\"allergies\":[],\"firstName\":\"Warren\",\"lastName\":\"Zemicks\",\"birthdate\":\"03/06/1985\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Zach\",\"lastName\":\"Zemicks\",\"birthdate\":\"03/06/2017\",\"medications\":[]},{\"allergies\":[\"illisoxian\"],\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"birthdate\":\"08/30/1979\",\"medications\":[\"thradox:700mg\"]},{\"allergies\":[],\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"birthdate\":\"03/06/1982\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Ron\",\"lastName\":\"Peters\",\"birthdate\":\"04/06/1965\",\"medications\":[]},{\"allergies\":[\"nillacilan\"],\"firstName\":\"Allison\",\"lastName\":\"Boyd\",\"birthdate\":\"03/15/1965\",\"medications\":[\"aznol:200mg\"]},{\"allergies\":[\"nillacilan\"],\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"birthdate\":\"12/06/1975\",\"medications\":[\"ibupurin:200mg\",\"hydrapermazol:400mg\"]},{\"allergies\":[],\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"birthdate\":\"07/08/1980\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"birthdate\":\"03/06/2014\",\"medications\":[\"noxidian:100mg\",\"pharmacol:2500mg\"]},{\"allergies\":[],\"firstName\":\"Clive\",\"lastName\":\"Ferguson\",\"birthdate\":\"03/06/1994\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"birthdate\":\"08/06/1945\",\"medications\":[\"tradoxidine:400mg\"]},{\"firstName\":\"sdfgdsfgfdg\",\"lastName\":\"Bodfgdsfgsdfgyd\",\"birthdate\":\"03/06/1980\",\"medications\":[\"aznol:350mg\",\"hydrapermazol:100mg\"],\"allergies\":[\"nillacilan\"]}]";
		
		MedicalRecordsCreate entity = new MedicalRecordsCreate();
		
		entity.setFirstName("sdfgdsfgfdg");
		entity.setLastName("Bodfgdsfgsdfgyd");	
		entity.setBirthdate("03/06/1980");
		
		Set<String> medication = new HashSet<>();
		medication.add("aznol:350mg");
		medication.add("hydrapermazol:100mg");
		entity.setMedications(medication);
		
		Set<String> allergies = new HashSet<>();
		allergies.add("nillacilan");
		entity.setAllergies(allergies);
		
		JSONArray result = medicalRecord.createMedicalRecord(entity);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}
	
	@Test
	public void getMedicalRecordTest() {
		
		String excepted = "{\"allergies\":[\"nillacilan\"],\"firstName\":\"John\",\"lastName\":\"Boyd\",\"birthdate\":\"03/06/1984\",\"medications\":[\"aznol:350mg\",\"hydrapermazol:100mg\"]}";
		
		JSONObject result = (JSONObject) medicalRecord.getMedicalRecord("John", "Boyd");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}
	
	@Test
	public void updateMedicalRecordTest() {
		
		String excepted = "[{\"allergies\":[\"nillacilan\"],\"firstName\":\"John\",\"lastName\":\"Boyd\",\"birthdate\":\"03/06/1980\",\"medications\":[\"aznol:350mg\",\"hydrapermazol:100mg\"]},{\"allergies\":[],\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"birthdate\":\"03/06/1989\",\"medications\":[\"pharmacol:5000mg\",\"terazine:10mg\",\"noznazol:250mg\"]},{\"allergies\":[\"peanut\"],\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"birthdate\":\"02/18/2012\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"birthdate\":\"09/06/2017\",\"medications\":[]},{\"allergies\":[\"xilliathal\"],\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"birthdate\":\"01/08/1986\",\"medications\":[\"tetracyclaz:650mg\"]},{\"allergies\":[],\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"birthdate\":\"01/03/1989\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Tessa\",\"lastName\":\"Carman\",\"birthdate\":\"02/18/2012\",\"medications\":[]},{\"allergies\":[\"shellfish\"],\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"birthdate\":\"09/06/2000\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Foster\",\"lastName\":\"Shepard\",\"birthdate\":\"01/08/1980\",\"medications\":[]},{\"allergies\":[\"shellfish\"],\"firstName\":\"Tony\",\"lastName\":\"Cooper\",\"birthdate\":\"03/06/1994\",\"medications\":[\"hydrapermazol:300mg\",\"dodoxadin:30mg\"]},{\"allergies\":[],\"firstName\":\"Lily\",\"lastName\":\"Cooper\",\"birthdate\":\"03/06/1994\",\"medications\":[]},{\"allergies\":[\"peanut\",\"shellfish\",\"aznol\"],\"firstName\":\"Sophia\",\"lastName\":\"Zemicks\",\"birthdate\":\"03/06/1988\",\"medications\":[\"aznol:60mg\",\"hydrapermazol:900mg\",\"pharmacol:5000mg\",\"terazine:500mg\"]},{\"allergies\":[],\"firstName\":\"Warren\",\"lastName\":\"Zemicks\",\"birthdate\":\"03/06/1985\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Zach\",\"lastName\":\"Zemicks\",\"birthdate\":\"03/06/2017\",\"medications\":[]},{\"allergies\":[\"illisoxian\"],\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"birthdate\":\"08/30/1979\",\"medications\":[\"thradox:700mg\"]},{\"allergies\":[],\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"birthdate\":\"03/06/1982\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Ron\",\"lastName\":\"Peters\",\"birthdate\":\"04/06/1965\",\"medications\":[]},{\"allergies\":[\"nillacilan\"],\"firstName\":\"Allison\",\"lastName\":\"Boyd\",\"birthdate\":\"03/15/1965\",\"medications\":[\"aznol:200mg\"]},{\"allergies\":[\"nillacilan\"],\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"birthdate\":\"12/06/1975\",\"medications\":[\"ibupurin:200mg\",\"hydrapermazol:400mg\"]},{\"allergies\":[],\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"birthdate\":\"07/08/1980\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"birthdate\":\"03/06/2014\",\"medications\":[\"noxidian:100mg\",\"pharmacol:2500mg\"]},{\"allergies\":[],\"firstName\":\"Clive\",\"lastName\":\"Ferguson\",\"birthdate\":\"03/06/1994\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"birthdate\":\"08/06/1945\",\"medications\":[\"tradoxidine:400mg\"]}]";
		
		MedicalRecordsCreate entity = new MedicalRecordsCreate();
		
		entity.setBirthdate("03/06/1980");
		
		Set<String> medication = new HashSet<>();
		medication.add("aznol:350mg");
		medication.add("hydrapermazol:100mg");
		entity.setMedications(medication);
		
		Set<String> allergies = new HashSet<>();
		allergies.add("nillacilan");
		entity.setAllergies(allergies);
		
		JSONArray result = medicalRecord.updateMedicalRecord("John", "Boyd", entity);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
		
	}
	
	@Test
	public void deleteMedicalRecordTest() {
		
		String excepted = "[{\"allergies\":[],\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"birthdate\":\"03/06/1989\",\"medications\":[\"pharmacol:5000mg\",\"terazine:10mg\",\"noznazol:250mg\"]},{\"allergies\":[\"peanut\"],\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"birthdate\":\"02/18/2012\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"birthdate\":\"09/06/2017\",\"medications\":[]},{\"allergies\":[\"xilliathal\"],\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"birthdate\":\"01/08/1986\",\"medications\":[\"tetracyclaz:650mg\"]},{\"allergies\":[],\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"birthdate\":\"01/03/1989\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Tessa\",\"lastName\":\"Carman\",\"birthdate\":\"02/18/2012\",\"medications\":[]},{\"allergies\":[\"shellfish\"],\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"birthdate\":\"09/06/2000\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Foster\",\"lastName\":\"Shepard\",\"birthdate\":\"01/08/1980\",\"medications\":[]},{\"allergies\":[\"shellfish\"],\"firstName\":\"Tony\",\"lastName\":\"Cooper\",\"birthdate\":\"03/06/1994\",\"medications\":[\"hydrapermazol:300mg\",\"dodoxadin:30mg\"]},{\"allergies\":[],\"firstName\":\"Lily\",\"lastName\":\"Cooper\",\"birthdate\":\"03/06/1994\",\"medications\":[]},{\"allergies\":[\"peanut\",\"shellfish\",\"aznol\"],\"firstName\":\"Sophia\",\"lastName\":\"Zemicks\",\"birthdate\":\"03/06/1988\",\"medications\":[\"aznol:60mg\",\"hydrapermazol:900mg\",\"pharmacol:5000mg\",\"terazine:500mg\"]},{\"allergies\":[],\"firstName\":\"Warren\",\"lastName\":\"Zemicks\",\"birthdate\":\"03/06/1985\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Zach\",\"lastName\":\"Zemicks\",\"birthdate\":\"03/06/2017\",\"medications\":[]},{\"allergies\":[\"illisoxian\"],\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"birthdate\":\"08/30/1979\",\"medications\":[\"thradox:700mg\"]},{\"allergies\":[],\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"birthdate\":\"03/06/1982\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Ron\",\"lastName\":\"Peters\",\"birthdate\":\"04/06/1965\",\"medications\":[]},{\"allergies\":[\"nillacilan\"],\"firstName\":\"Allison\",\"lastName\":\"Boyd\",\"birthdate\":\"03/15/1965\",\"medications\":[\"aznol:200mg\"]},{\"allergies\":[\"nillacilan\"],\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"birthdate\":\"12/06/1975\",\"medications\":[\"ibupurin:200mg\",\"hydrapermazol:400mg\"]},{\"allergies\":[],\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"birthdate\":\"07/08/1980\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"birthdate\":\"03/06/2014\",\"medications\":[\"noxidian:100mg\",\"pharmacol:2500mg\"]},{\"allergies\":[],\"firstName\":\"Clive\",\"lastName\":\"Ferguson\",\"birthdate\":\"03/06/1994\",\"medications\":[]},{\"allergies\":[],\"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"birthdate\":\"08/06/1945\",\"medications\":[\"tradoxidine:400mg\"]}]";
		
		JSONArray result = medicalRecord.deleteMedicalRecord("John", "Boyd");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
		
	}

}
