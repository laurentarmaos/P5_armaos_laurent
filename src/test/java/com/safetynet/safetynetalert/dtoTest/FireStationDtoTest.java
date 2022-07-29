package com.safetynet.safetynetalert.dtoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalert.domain.dtos.FireStationDto;

@SpringBootTest
public class FireStationDtoTest {
	
	private static final String ADDRESS = "address";
	private static final String STATION = "station";
	
	private FireStationDto fireStation = new FireStationDto();
	
	@BeforeEach
	public void setup() {
		fireStation.setAddress(ADDRESS);
		fireStation.setStation(STATION);
	}

	
	@Test
	public void addressTest() {
		assertEquals(ADDRESS, fireStation.getAddress());
	}
	
	@Test
	public void stationTest() {
		assertEquals(STATION, fireStation.getStation());
	}
}
