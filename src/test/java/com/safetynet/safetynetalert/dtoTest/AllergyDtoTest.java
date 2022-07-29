package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.AllergyDto;

@SpringBootTest
public class AllergyDtoTest {
	
	private static final String ALLERGY_NAME = "allergy_name";
	
	private AllergyDto allergyDto = new AllergyDto();
	
	
	@Test
	public void allergyNameTest() {
		allergyDto.setAllergyName(ALLERGY_NAME);
		assertEquals(ALLERGY_NAME, allergyDto.getAllergyName());
	}
}
