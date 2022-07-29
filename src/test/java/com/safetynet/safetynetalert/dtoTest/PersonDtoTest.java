package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.PersonDto;

@SpringBootTest
public class PersonDtoTest {
	
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final Date BIRTHDATE = new Date();
	private static final String ADDRESS = "address";
	private static final String CITY = "city";
	private static final String ZIP = "zip";
	private static final String PHONE = "phone";
	private static final String EMAIL = "email";
	private static final double AGE = 20;
	private static final Set<String> ALLERGIES = new HashSet <String>();
	private static final Set<String> MEDICATIONS = new HashSet <String>();
	
	private PersonDto personDtoTest = new PersonDto();
	
	@BeforeEach
	public void setup() {
		personDtoTest.setFirstName(FIRST_NAME);
		personDtoTest.setLastName(LAST_NAME);
		personDtoTest.setBirthDate(BIRTHDATE);
		personDtoTest.setAddress(ADDRESS);
		personDtoTest.setCity(CITY);
		personDtoTest.setZipCode(ZIP);
		personDtoTest.setPhone(PHONE);
		personDtoTest.setEmail(EMAIL);
		personDtoTest.setAge(AGE);
		personDtoTest.setAllergies(ALLERGIES);
		personDtoTest.setMedications(MEDICATIONS);
	}
	
	@Test
	public void firstNameTest () {
		assertEquals(FIRST_NAME, personDtoTest.getFirstName());
	}
	
	@Test
	public void lastNameTest () {
		assertEquals(LAST_NAME, personDtoTest.getLastName());
	}
	
	@Test
	public void birthdateTest () {
		assertEquals(BIRTHDATE, personDtoTest.getBirthDate());
	}
	
	@Test
	public void addressTest () {
		assertEquals(ADDRESS, personDtoTest.getAddress());
	}
	
	@Test
	public void cityTest () {
		assertEquals(CITY, personDtoTest.getCity());
	}
	
	@Test
	public void zipTest () {
		assertEquals(ZIP, personDtoTest.getZipCode());
	}
	
	@Test
	public void phoneTest () {
		assertEquals(PHONE, personDtoTest.getPhone());
	}
	
	@Test
	public void emailTest () {
		assertEquals(EMAIL, personDtoTest.getEmail());
	}
	
	@Test
	public void ageTest () {
		assertEquals(AGE, personDtoTest.getAge());
	}
	
	@Test
	public void allergiesTest () {
		assertEquals(ALLERGIES, personDtoTest.getAllergies());
	}
	
	@Test
	public void medicationsTest () {
		assertEquals(MEDICATIONS, personDtoTest.getMedications());
	}

}
