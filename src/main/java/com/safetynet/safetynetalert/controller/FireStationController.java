package com.safetynet.safetynetalert.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public @ResponseBody JSONArray createFireStation(@RequestBody FireStationDto dto) {
		return service.createFireStation(dto);
	}
	
	@GetMapping
	public @ResponseBody JSONObject getFireStation(@RequestParam String address) {
		return service.getFireStation(address);
	}
	
	
	@PutMapping("/update")
	public @ResponseBody JSONObject updateFireStation(String address) {
		return service.updateFireStation(address);
	}

	
	@DeleteMapping("/delete")
	public @ResponseBody JSONObject deleteFireStation(String address) {
		return service.deleteFireStation(address);
	}
	
	
}
