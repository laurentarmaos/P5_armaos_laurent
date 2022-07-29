package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.FireAlertDto;

@SpringBootTest
public class FireAlertDtoTest {
	
	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
	private static final String PHONE = "111 222";
	private static final double AGE = 10;
	private static final Set<String> ALLERGIES = new HashSet<String>();
	private static final Set<String> MEDICATIONS = new HashSet<String>();
	
	private FireAlertDto fireAlert = new FireAlertDto(FIRST_NAME, LAST_NAME, PHONE, AGE, ALLERGIES, MEDICATIONS);
	
	@Test
	public void firstNameTest() {
		assertEquals(FIRST_NAME, fireAlert.getFirstName());
	}
	
	@Test
	public void lastNameTest() {
		assertEquals(LAST_NAME, fireAlert.getLastName());
	}
	
	@Test
	public void phoneTest() {
		assertEquals(PHONE, fireAlert.getPhone());
	}
	
	@Test
	public void ageTest() {
		assertEquals(AGE, fireAlert.getAge());
	}
	
	@Test
	public void allergiesTest() {
		assertEquals(ALLERGIES, fireAlert.getAllergies());
	}
	
	@Test
	public void medicationsTest() {
		assertEquals(MEDICATIONS, fireAlert.getMedications());
	}
	
}
