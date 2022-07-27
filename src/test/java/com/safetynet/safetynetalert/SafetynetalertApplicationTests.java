package com.safetynet.safetynetalert;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.controller.ChildAlertController;
import com.safetynet.safetynetalert.controller.CommunityEmailController;
import com.safetynet.safetynetalert.controller.FireAlertController;
import com.safetynet.safetynetalert.controller.FireStationPersonsInfosController;
import com.safetynet.safetynetalert.controller.PersonInfoController;
import com.safetynet.safetynetalert.controller.PhoneAlertController;
import com.safetynet.safetynetalert.controller.StationsPersonsInfosController;

@SpringBootTest
class SafetynetalertApplicationTests {

	@Autowired
	private ChildAlertController alert;
	
	@Autowired
	private CommunityEmailController communityEmail;
	
	@Autowired
	private FireAlertController fireAlert;
	
	@Autowired
	private FireStationPersonsInfosController fireStationPersonInfo;
	
	@Autowired
	private PersonInfoController personInfo;
	
	@Autowired
	private PhoneAlertController phoneAlert;
	
	@Autowired
	private StationsPersonsInfosController stationsPersonsInfos;
	
	@Test
	void contextLoads() {
	}
	
	
	
	@Test
	public void childAlertTest(){
		
		String excepted = "[{\"firstName\":\"John\",\"lastName\":\"Boyd\"},{\"firstName\":\"Jacob\",\"lastName\":\"Boyd\"},{\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"age\":11.0},{\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"age\":5.0},{\"firstName\":\"Felicia\",\"lastName\":\"Boyd\"}]";
		
		List<Object> result = alert.childAlert("1509 Culver St");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}
	
	
	@Test
	public void communityEmailTest() {
		
		String excepted = "[{\"email\":\"jaboyd@email.com\"},{\"email\":\"drk@email.com\"},{\"email\":\"tenz@email.com\"},{\"email\":\"jaboyd@email.com\"},{\"email\":\"jaboyd@email.com\"},{\"email\":\"drk@email.com\"},{\"email\":\"tenz@email.com\"},{\"email\":\"jaboyd@email.com\"},{\"email\":\"jaboyd@email.com\"},{\"email\":\"tcoop@ymail.com\"},{\"email\":\"lily@email.com\"},{\"email\":\"soph@email.com\"},{\"email\":\"ward@email.com\"},{\"email\":\"zarc@email.com\"},{\"email\":\"reg@email.com\"},{\"email\":\"jpeter@email.com\"},{\"email\":\"jpeter@email.com\"},{\"email\":\"aly@imail.com\"},{\"email\":\"bstel@email.com\"},{\"email\":\"ssanw@email.com\"},{\"email\":\"bstel@email.com\"},{\"email\":\"clivfd@ymail.com\"},{\"email\":\"gramps@email.com\"}]";
		
		List<Object> result = communityEmail.getEmails("Culver");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}
	
	
	@Test
	public void fireAlertTest() {
		
		String excepted = "[{\"address\":\"1509 Culver St\",\"station\":\"3\"},{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6512\",\"age\":39.0,\"allergies\":[\"aznol:350mg\",\"hydrapermazol:100mg\"],\"medications\":[\"nillacilan\"]},{\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6513\",\"age\":34.0,\"allergies\":[\"pharmacol:5000mg\",\"terazine:10mg\",\"noznazol:250mg\"],\"medications\":[]},{\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6512\",\"age\":11.0,\"allergies\":[],\"medications\":[\"peanut\"]},{\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6512\",\"age\":5.0,\"allergies\":[],\"medications\":[]},{\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6544\",\"age\":37.0,\"allergies\":[\"tetracyclaz:650mg\"],\"medications\":[\"xilliathal\"]}]";
		
		List<Object> result = fireAlert.fireAlert("1509 Culver St");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}
	
	
	@Test
	public void fireStationPersonInfosTest() {
		
		String excepted = "[{\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"address\":\"644 Gershwin Cir\",\"phone\":\"841-874-6512\"},{\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"address\":\"908 73rd St\",\"phone\":\"841-874-8547\"},{\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"address\":\"908 73rd St\",\"phone\":\"841-874-7462\"},{\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"phone\":\"841-874-7784\"},{\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"phone\":\"841-874-7784\"},{\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"phone\":\"841-874-7784\"},\"childs : 1\",\" adults : 5\"]";
		
		List<Object> result = fireStationPersonInfo.fireStationPersonsInfos("1");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}
	
	
	@Test
	public void personInfoTest() {
		
		String excepted = "[{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"email\":\"jaboyd@email.com\",\"age\":39.0,\"allergies\":[\"nillacilan\"],\"medications\":[\"aznol:350mg\",\"hydrapermazol:100mg\"]}]";
		
		List<Object> result = personInfo.personInfo("John", "Boyd");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
		
	}
	
	
	@Test
	public void phoneAlertTest() {
		
		String excepted = "[{\"phone\":\"841-874-6512\"},{\"phone\":\"841-874-8547\"},{\"phone\":\"841-874-7462\"},{\"phone\":\"841-874-7784\"},{\"phone\":\"841-874-7784\"},{\"phone\":\"841-874-7784\"}]";
		
		List<Object> result = phoneAlert.phoneAlert("1");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}
	
	@Test
	public void stationsPersonsInfosTest() {
		
		String excepted = "[{\"address\":\"644 Gershwin Cir\",\"station\":\"1\"},{\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"phone\":\"841-874-6512\",\"age\":22.0,\"allergies\":[],\"medications\":[\"shellfish\"]},{\"address\":\"908 73rd St\",\"station\":\"1\"},{\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"phone\":\"841-874-8547\",\"age\":43.0,\"allergies\":[\"thradox:700mg\"],\"medications\":[\"illisoxian\"]},{\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"phone\":\"841-874-7462\",\"age\":41.0,\"allergies\":[],\"medications\":[]},{\"address\":\"947 E. Rose Dr\",\"station\":\"1\"},{\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"phone\":\"841-874-7784\",\"age\":47.0,\"allergies\":[\"hydrapermazol:400mg\",\"ibupurin:200mg\"],\"medications\":[\"nillacilan\"]},{\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"phone\":\"841-874-7784\",\"age\":43.0,\"allergies\":[],\"medications\":[]},{\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"phone\":\"841-874-7784\",\"age\":9.0,\"allergies\":[\"pharmacol:2500mg\",\"noxidian:100mg\"],\"medications\":[]}]";
		
		List<Object> result = stationsPersonsInfos.stationsersonInfos("1");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
		
	}

}
