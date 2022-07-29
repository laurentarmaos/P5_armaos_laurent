package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.PhoneAlertDto;

@SpringBootTest
public class PhoneAlertDtoTest {
	
	private static final String PHONE = "phone";
	
	private PhoneAlertDto phoneAlertDtoTest = new PhoneAlertDto(PHONE);
	
	
	@Test
	public void phoneTest() {
		assertEquals(PHONE, phoneAlertDtoTest.getPhone());
	}

}
