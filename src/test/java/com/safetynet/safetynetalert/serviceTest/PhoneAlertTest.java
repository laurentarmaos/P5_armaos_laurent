package com.safetynet.safetynetalert.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.service.PhoneAlertService;


@SpringBootTest
public class PhoneAlertTest {
	
	@Autowired
	private PhoneAlertService phoneAlert;
	
	@Test
	public void phoneAlertTest() {
		
		String excepted = "[{\"phone\":\"841-874-6512\"},{\"phone\":\"841-874-8547\"},{\"phone\":\"841-874-7462\"},{\"phone\":\"841-874-7784\"},{\"phone\":\"841-874-7784\"},{\"phone\":\"841-874-7784\"}]";
		
		List<Object> result = phoneAlert.alert("1");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}

}
