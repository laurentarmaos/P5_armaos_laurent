package com.safetynet.safetynetalert.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.domain.dtos.FireStationDto;
import com.safetynet.safetynetalert.service.FireStationService;

@SpringBootTest
public class FireStationTest {
	
	@Autowired
	private FireStationService fireStation;

	
	@Test
	public void createFireStationTest() {
		
		String excepted = "[{\"address\":\"1509 Culver St\",\"station\":\"3\"},{\"address\":\"29 15th St\",\"station\":\"2\"},{\"address\":\"834 Binoc Ave\",\"station\":\"3\"},{\"address\":\"644 Gershwin Cir\",\"station\":\"1\"},{\"address\":\"748 Townings Dr\",\"station\":\"3\"},{\"address\":\"112 Steppes Pl\",\"station\":\"3\"},{\"address\":\"489 Manchester St\",\"station\":\"4\"},{\"address\":\"892 Downing Ct\",\"station\":\"2\"},{\"address\":\"908 73rd St\",\"station\":\"1\"},{\"address\":\"112 Steppes Pl\",\"station\":\"4\"},{\"address\":\"947 E. Rose Dr\",\"station\":\"1\"},{\"address\":\"748 Townings Dr\",\"station\":\"3\"},{\"address\":\"951 LoneTree Rd\",\"station\":\"2\"},{\"address\":\"123123123\",\"station\":\"5\"}]";

		
		FireStationDto entity = new FireStationDto();
		
		entity.setAddress("123123123");
		entity.setStation("5");
		
		JSONArray result = fireStation.createFireStation(entity);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}
	
	@Test
	public void getFireStationTest() {
		
		String excepted = "{\"address\":\"1509 Culver St\",\"station\":\"3\"}";
		
		JSONObject result = (JSONObject) fireStation.getFireStation("1509 Culver St");
		
		assertEquals(excepted, result.toJSONString());
	}
	
	@Test
	public void updateFireStationTest() {
		
		String excepted = "[{\"address\":\"1509 Culver St\",\"station\":\"5\"},{\"address\":\"29 15th St\",\"station\":\"2\"},{\"address\":\"834 Binoc Ave\",\"station\":\"3\"},{\"address\":\"644 Gershwin Cir\",\"station\":\"1\"},{\"address\":\"748 Townings Dr\",\"station\":\"3\"},{\"address\":\"112 Steppes Pl\",\"station\":\"3\"},{\"address\":\"489 Manchester St\",\"station\":\"4\"},{\"address\":\"892 Downing Ct\",\"station\":\"2\"},{\"address\":\"908 73rd St\",\"station\":\"1\"},{\"address\":\"112 Steppes Pl\",\"station\":\"4\"},{\"address\":\"947 E. Rose Dr\",\"station\":\"1\"},{\"address\":\"748 Townings Dr\",\"station\":\"3\"},{\"address\":\"951 LoneTree Rd\",\"station\":\"2\"}]";
		
		FireStationDto entity = new FireStationDto();
		entity.setStation("5");
		
		
		JSONArray result = fireStation.updateFireStation("1509 Culver St", entity);
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
		
	}
	
	@Test
	public void deleteFireStationTest() {
		
		String excepted = "[{\"address\":\"29 15th St\",\"station\":\"2\"},{\"address\":\"834 Binoc Ave\",\"station\":\"3\"},{\"address\":\"644 Gershwin Cir\",\"station\":\"1\"},{\"address\":\"748 Townings Dr\",\"station\":\"3\"},{\"address\":\"112 Steppes Pl\",\"station\":\"3\"},{\"address\":\"489 Manchester St\",\"station\":\"4\"},{\"address\":\"892 Downing Ct\",\"station\":\"2\"},{\"address\":\"908 73rd St\",\"station\":\"1\"},{\"address\":\"112 Steppes Pl\",\"station\":\"4\"},{\"address\":\"947 E. Rose Dr\",\"station\":\"1\"},{\"address\":\"748 Townings Dr\",\"station\":\"3\"},{\"address\":\"951 LoneTree Rd\",\"station\":\"2\"}]";

		
		JSONArray result = fireStation.deleteFireStation("1509 Culver St");
		
		assertEquals(excepted, result.toJSONString());
		
	}

}
