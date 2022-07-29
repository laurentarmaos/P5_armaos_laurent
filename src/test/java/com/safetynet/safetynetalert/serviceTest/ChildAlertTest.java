package com.safetynet.safetynetalert.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.service.ChildAlertService;

@SpringBootTest
public class ChildAlertTest {
	
	@Autowired
	private ChildAlertService alert;
	
	@Test
	public void childAlertTest(){
		
		String excepted = "[{\"firstName\":\"John\",\"lastName\":\"Boyd\"},{\"firstName\":\"Jacob\",\"lastName\":\"Boyd\"},{\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"age\":11.0},{\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"age\":5.0},{\"firstName\":\"Felicia\",\"lastName\":\"Boyd\"}]";
		
		List<Object> result = alert.childAlert("1509 Culver St");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}

}
