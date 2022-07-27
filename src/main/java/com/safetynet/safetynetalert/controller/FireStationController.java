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
	
	@GetMapping("/get")
	public @ResponseBody JSONObject getFireStation(@RequestParam String address) {
		return service.getFireStation(address);
	}
	
	
	@PutMapping("/update")
	public @ResponseBody JSONArray updateFireStation(String address, @RequestBody FireStationDto dto) {
		return service.updateFireStation(address, dto);
	}

	
	@DeleteMapping("/delete")
	public @ResponseBody JSONArray deleteFireStation(String address) {
		return service.deleteFireStation(address);
	}
	
	
}
