package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.PersonCreate;

@SpringBootTest
public class PersonCreateTest {
	
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String ADDRESS = "address";
	private static final String CITY = "city";
	private static final String ZIP = "zip";
	private static final String PHONE = "phone";
	private static final String EMAIL = "email";
	
	private PersonCreate personCreateTest = new PersonCreate();
	
	@BeforeEach
	public void setup() {
		personCreateTest.setFirstName(FIRST_NAME);
		personCreateTest.setLastName(LAST_NAME);
		personCreateTest.setAddress(ADDRESS);
		personCreateTest.setCity(CITY);
		personCreateTest.setZip(ZIP);
		personCreateTest.setPhone(PHONE);
		personCreateTest.setEmail(EMAIL);
	}

	
	@Test
	public void firstNameTest() {
		assertEquals(FIRST_NAME, personCreateTest.getFirstName());
	}
	
	@Test
	public void lastNameTest() {
		assertEquals(LAST_NAME, personCreateTest.getLastName());
	}
	
	@Test
	public void addressTest() {
		assertEquals(ADDRESS, personCreateTest.getAddress());
	}
	
	@Test
	public void cityTest() {
		assertEquals(CITY, personCreateTest.getCity());
	}
	
	@Test
	public void zipTest() {
		assertEquals(ZIP, personCreateTest.getZip());
	}
	
	@Test
	public void phoneTest() {
		assertEquals(PHONE, personCreateTest.getPhone());
	}
	
	@Test
	public void emailTest() {
		assertEquals(EMAIL, personCreateTest.getEmail());
	}
}
