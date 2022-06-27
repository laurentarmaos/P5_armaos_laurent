package com.safetynet.safetynetalert.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flood/station")
public class StationsPersonsInfosController {

	@GetMapping
	public @ResponseBody String stationsersonInfos(@RequestParam("station") String stationNumber) {
		
		return stationNumber;
	}
}
