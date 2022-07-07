package com.safetynet.safetynetalert.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalert.service.FireStationPersonsInfosService;
import com.safetynet.safetynetalert.service.FireStationPersonsInfosServiceImpl;

@RestController
@RequestMapping("/firestation")
public class FireStationPersonsInfosController {
	
	private final FireStationPersonsInfosService service;
		

	public FireStationPersonsInfosController(FireStationPersonsInfosServiceImpl service) {
		this.service = service;
	}



	@GetMapping
	public @ResponseBody List<Object> fireStationPersonsInfos(@RequestParam("stationNumber") String stationNumber) {
		
		return service.fireStationPersonsInfos(stationNumber);
	}
}
