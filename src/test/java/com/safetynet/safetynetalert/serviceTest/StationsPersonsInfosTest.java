package com.safetynet.safetynetalert.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.service.StationsPersonsInfosService;


@SpringBootTest
public class StationsPersonsInfosTest {
	
	@Autowired
	private StationsPersonsInfosService stationsPersonsInfos;
	
	@Test
	public void stationsPersonsInfosTest() {
		
		String excepted = "[{\"address\":\"644 Gershwin Cir\",\"station\":\"1\"},{\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"phone\":\"841-874-6512\",\"age\":22.0,\"allergies\":[],\"medications\":[\"shellfish\"]},{\"address\":\"908 73rd St\",\"station\":\"1\"},{\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"phone\":\"841-874-8547\",\"age\":43.0,\"allergies\":[\"thradox:700mg\"],\"medications\":[\"illisoxian\"]},{\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"phone\":\"841-874-7462\",\"age\":41.0,\"allergies\":[],\"medications\":[]},{\"address\":\"947 E. Rose Dr\",\"station\":\"1\"},{\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"phone\":\"841-874-7784\",\"age\":47.0,\"allergies\":[\"hydrapermazol:400mg\",\"ibupurin:200mg\"],\"medications\":[\"nillacilan\"]},{\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"phone\":\"841-874-7784\",\"age\":43.0,\"allergies\":[],\"medications\":[]},{\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"phone\":\"841-874-7784\",\"age\":9.0,\"allergies\":[\"pharmacol:2500mg\",\"noxidian:100mg\"],\"medications\":[]}]";
		
		List<Object> result = stationsPersonsInfos.stationPersonsInfo("1");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
		
	}

}
