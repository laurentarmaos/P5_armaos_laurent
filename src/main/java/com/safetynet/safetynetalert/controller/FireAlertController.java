package com.safetynet.safetynetalert.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalert.service.FireAlertService;

@RestController
@RequestMapping("/fire")
public class FireAlertController {
	
	private final FireAlertService service;
	
	

	public FireAlertController(FireAlertService service) {
		this.service = service;
	}



	@GetMapping
	public @ResponseBody List<Object> fireAlert(@RequestParam("address") String address) {
		
		return service.fireAlert(address);
	}
}
