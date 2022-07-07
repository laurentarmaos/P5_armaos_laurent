package com.safetynet.safetynetalert.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalert.service.StationsPersonsInfosService;
import com.safetynet.safetynetalert.service.StationsPersonsInfosServiceImpl;

@RestController
@RequestMapping("/flood/station")
public class StationsPersonsInfosController {
	
	private final StationsPersonsInfosService service;
	
	

	public StationsPersonsInfosController(StationsPersonsInfosServiceImpl service) {
		this.service = service;
	}



	@GetMapping
	public @ResponseBody List<Object> stationsersonInfos(@RequestParam("station") String stationNumber) {
		
		return service.stationPersonsInfo(stationNumber);
	}
}
