package com.safetynet.safetynetalert.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.service.FireAlertService;


@SpringBootTest
public class FireAlertTest {
	
	@Autowired
	private FireAlertService fireAlert;
	
	@Test
	public void fireAlertTest() {
		
		String excepted = "[{\"address\":\"1509 Culver St\",\"station\":\"3\"},{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6512\",\"age\":39.0,\"allergies\":[\"aznol:350mg\",\"hydrapermazol:100mg\"],\"medications\":[\"nillacilan\"]},{\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6513\",\"age\":34.0,\"allergies\":[\"pharmacol:5000mg\",\"terazine:10mg\",\"noznazol:250mg\"],\"medications\":[]},{\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6512\",\"age\":11.0,\"allergies\":[],\"medications\":[\"peanut\"]},{\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6512\",\"age\":5.0,\"allergies\":[],\"medications\":[]},{\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6544\",\"age\":37.0,\"allergies\":[\"tetracyclaz:650mg\"],\"medications\":[\"xilliathal\"]}]";
		
		List<Object> result = fireAlert.fireAlert("1509 Culver St");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}

}
