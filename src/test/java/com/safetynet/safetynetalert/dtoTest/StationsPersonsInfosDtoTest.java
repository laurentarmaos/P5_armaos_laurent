package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.StationsPersonsInfosDto;

@SpringBootTest
public class StationsPersonsInfosDtoTest {
	
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String PHONE = "phone";
	private static final double AGE = 20;
	private static final Set<String> ALLERGIES = new HashSet <String>();
	private static final Set<String> MEDICATIONS = new HashSet <String>();
	
	private StationsPersonsInfosDto stationsPersonsInfosDto = new StationsPersonsInfosDto(FIRST_NAME, LAST_NAME, PHONE, AGE, ALLERGIES, MEDICATIONS);
	
	@Test
	public void firstNameTest() {
		assertEquals(FIRST_NAME, stationsPersonsInfosDto.getFirstName());
	}
	
	@Test
	public void lastNameTest() {
		assertEquals(LAST_NAME, stationsPersonsInfosDto.getLastName());
	}
	
	@Test
	public void phoneTest() {
		assertEquals(PHONE, stationsPersonsInfosDto.getPhone());
	}
	
	@Test
	public void ageTest() {
		assertEquals(AGE, stationsPersonsInfosDto.getAge());
	}
	
	@Test
	public void allergiesTest() {
		assertEquals(ALLERGIES, stationsPersonsInfosDto.getAllergies());
	}
	
	@Test
	public void medicationsTest() {
		assertEquals(MEDICATIONS, stationsPersonsInfosDto.getMedications());
	}

}
