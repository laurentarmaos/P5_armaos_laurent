package com.safetynet.safetynetalert.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fire")
public class FireAlertController {

	@GetMapping
	public @ResponseBody String fireAlert(@RequestParam("address") String address) {
		
		return address;
	}
}
