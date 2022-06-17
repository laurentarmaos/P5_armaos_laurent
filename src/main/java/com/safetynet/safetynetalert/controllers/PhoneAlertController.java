package com.safetynet.safetynetalert.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phoneAlert")
public class PhoneAlertController {

	@GetMapping
	public @ResponseBody String phoneAlert(@RequestParam("firestation") String firestation){
		
		return firestation;
	}
}
