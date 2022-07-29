package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.MedicationDto;

@SpringBootTest
public class MedicationDtoTest {

	private static final String MEDICATION_NAME = "medic_name";
	
	private MedicationDto medicationTest = new MedicationDto();
	
	@BeforeEach
	public void setup() {
		medicationTest.setMedicationName(MEDICATION_NAME);
	}
	
	@Test
	public void medicationNameTest() {
		assertEquals(MEDICATION_NAME, medicationTest.getMedicationName());
	}
}
