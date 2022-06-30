package com.safetynet.safetynetalert.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalert.service.PhoneAlertService;

@RestController
@RequestMapping("/phoneAlert")
public class PhoneAlertController {
	
	private final PhoneAlertService service;
	
	public PhoneAlertController(PhoneAlertService service) {
		this.service = service;
	}

	@GetMapping
	public @ResponseBody void phoneAlert(@RequestParam("firestation") String firestation){
		
		service.alert(firestation);
	}
}
