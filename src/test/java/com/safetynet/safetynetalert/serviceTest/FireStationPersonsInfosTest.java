package com.safetynet.safetynetalert.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.safetynet.safetynetalert.service.FireStationPersonsInfosService;


@SpringBootTest
public class FireStationPersonsInfosTest {
	
	@Autowired
	private FireStationPersonsInfosService fireStationPersonInfo;
	
	@Test
	public void fireStationPersonInfosTest() {
		
		String excepted = "[{\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"address\":\"644 Gershwin Cir\",\"phone\":\"841-874-6512\"},{\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"address\":\"908 73rd St\",\"phone\":\"841-874-8547\"},{\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"address\":\"908 73rd St\",\"phone\":\"841-874-7462\"},{\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"phone\":\"841-874-7784\"},{\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"phone\":\"841-874-7784\"},{\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"phone\":\"841-874-7784\"},\"childs : 1\",\" adults : 5\"]";
		
		List<Object> result = fireStationPersonInfo.fireStationPersonsInfos("1");
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		
		assertEquals(excepted, jsonString);
	}

}
