package com.safetynet.safetynetalert.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.service.PersonInfoService;


@SpringBootTest
public class PersonInfoTest {
	
	@Autowired
	private PersonInfoService personInfo;
	
	@Test
	public void personInfoTest() {
		
		String excepted = "[{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"email\":\"jaboyd@email.com\",\"age\":39.0,\"allergies\":[\"nillacilan\"],\"medications\":[\"aznol:350mg\",\"hydrapermazol:100mg\"]}]";
		
		List<Object> result = personInfo.personInfo("John", "Boyd");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
		
	}

}
