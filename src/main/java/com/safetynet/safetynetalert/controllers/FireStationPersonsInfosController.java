package com.safetynet.safetynetalert.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firestation")
public class FireStationPersonsInfosController {

	@GetMapping
	public @ResponseBody String fireStationPersonsInfos(@RequestParam("stationNumber") String stationNumber) {
		
		return stationNumber;
	}
}
