package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.PersonInfoDto;

@SpringBootTest
public class PersonInfoDtoTest {
	
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String ADDRESS = "address";
	private static final String EMAIL = "email";
	private static final double AGE = 20;
	private static final Set<String> ALLERGIES = new HashSet <String>();
	private static final Set<String> MEDICATIONS = new HashSet <String>();
	
	
	PersonInfoDto personInfoDtoTest = new PersonInfoDto(FIRST_NAME, LAST_NAME, ADDRESS, EMAIL, AGE, ALLERGIES, MEDICATIONS);
	
	@Test
	public void firstNameTest() {
		assertEquals(FIRST_NAME, personInfoDtoTest.getFirstName());
	}
	
	@Test
	public void lastNameTest() {
		assertEquals(LAST_NAME, personInfoDtoTest.getLastName());
	}
	
	@Test
	public void addressTest() {
		assertEquals(ADDRESS, personInfoDtoTest.getAddress());
	}
	
	@Test
	public void emailTest() {
		assertEquals(EMAIL, personInfoDtoTest.getEmail());
	}
	
	@Test
	public void ageTest() {
		assertEquals(AGE, personInfoDtoTest.getAge());
	}
	
	@Test
	public void allergiesTest() {
		assertEquals(ALLERGIES, personInfoDtoTest.getAllergies());
	}
	
	@Test
	public void medicationsTest() {
		assertEquals(MEDICATIONS, personInfoDtoTest.getMedications());
	}
	

}
