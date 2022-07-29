package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.MedicalRecordsCreate;

@SpringBootTest
public class MedicalRecordsCreateTest {
	
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String BIRTH_DATE = "birthDate";
	private static final Set<String> MEDICATIONS = new HashSet<>();
	private static final Set<String> ALLERGIES = new HashSet<>();
	
	private MedicalRecordsCreate medicalRecordsCreate = new MedicalRecordsCreate();
	
	@BeforeEach
	public void setup() {
		medicalRecordsCreate.setFirstName(FIRST_NAME);
		medicalRecordsCreate.setLastName(LAST_NAME);
		medicalRecordsCreate.setBirthdate(BIRTH_DATE);
		medicalRecordsCreate.setMedications(MEDICATIONS);
		medicalRecordsCreate.setAllergies(ALLERGIES);
	}
	
	@Test
	public void firstNameTest() {
		assertEquals(FIRST_NAME, medicalRecordsCreate.getFirstName());
	}
	
	@Test
	public void lastNameTest() {
		assertEquals(LAST_NAME, medicalRecordsCreate.getLastName());
	}
	
	@Test 
	public void birthDateTest() {
		assertEquals(BIRTH_DATE, medicalRecordsCreate.getBirthdate());
	}
	
	@Test
	public void medicationsTest() {
		assertEquals(MEDICATIONS, medicalRecordsCreate.getMedications());
	}
	
	@Test
	public void allergiesTest() {
		assertEquals(ALLERGIES, medicalRecordsCreate.getAllergies());
	}

}
