package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.ChildAlertMiDto;

@SpringBootTest
public class ChildAlertMiDtoTest {
	
	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
	private static final double AGE = 10;
	
	private ChildAlertMiDto childAlertMiDto = new ChildAlertMiDto(FIRST_NAME, LAST_NAME, AGE);
	
	@Test
	public void firstNameTest() {
		assertEquals(FIRST_NAME, childAlertMiDto.getFirstName());
	}
	
	@Test
	public void lastNameTest() {
		assertEquals(LAST_NAME, childAlertMiDto.getLastName());
	}
	
	@Test
	public void ageTest() {
		assertEquals(AGE, 10);
	}

}
