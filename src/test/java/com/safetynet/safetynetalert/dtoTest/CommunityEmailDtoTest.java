package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.CommunityEmailDto;

@SpringBootTest
public class CommunityEmailDtoTest {
	
	private static final String EMAIL = "email";
	
	private CommunityEmailDto email = new CommunityEmailDto(EMAIL);
	
	public void emailTest() {
		assertEquals(EMAIL, email.getEmail());
	}

}
