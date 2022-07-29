package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.ChildAlertMaDto;

@SpringBootTest
public class ChildAlertMaDtoTest {
	
	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
	
	private ChildAlertMaDto childAlertMaDto = new ChildAlertMaDto(FIRST_NAME, LAST_NAME);
	
	@Test
	public void firstNameTest() {
		assertEquals(FIRST_NAME, childAlertMaDto.getFirstName());
	}
	
	@Test
	public void lastNameTest() {
		assertEquals(LAST_NAME, childAlertMaDto.getLastName());
	}

}
