package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.FireStationPersonsInfosDto;

@SpringBootTest
public class FireStationPersonsInfosDtoTest {
	
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String ADDRESS = "address";
	private static final String PHONE = "phone";
	
	private FireStationPersonsInfosDto personsInfos = new FireStationPersonsInfosDto(FIRST_NAME, LAST_NAME, ADDRESS, PHONE);
	

	@Test
	public void firstNameTest() {
		assertEquals(FIRST_NAME, personsInfos.getFirstName());
	}
	
	@Test
	public void lastNameTest() {
		assertEquals(LAST_NAME, personsInfos.getLastName());
	}
	
	@Test
	public void addressTest() {
		assertEquals(ADDRESS, personsInfos.getAddress());
	}
	
	@Test
	public void phoneTest() {
		assertEquals(PHONE, personsInfos.getPhone());
	}

}
