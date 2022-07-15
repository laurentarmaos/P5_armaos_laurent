package com.safetynet.safetynetalert.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalert.domain.dtos.FireStationDto;
import com.safetynet.safetynetalert.service.FireStationService;

@RestController
@RequestMapping("/firestation")
public class FireStationController {
	
	private final FireStationService service;
	
	
	public FireStationController(FireStationService service) {
		this.service = service;
	}


	@PostMapping("/create")
	public @ResponseBody FireStationDto createFireStation() {
		return service.createFireStation();
	}
	
	
	@PutMapping("/update")
	public @ResponseBody FireStationDto updateFireStation(String address) {
		return service.updateFireStation(address);
	}

	
	@DeleteMapping("/delete")
	public @ResponseBody FireStationDto deleteFireStation(String address) {
		return service.deleteFireStation(address);
	}
	
	
}
