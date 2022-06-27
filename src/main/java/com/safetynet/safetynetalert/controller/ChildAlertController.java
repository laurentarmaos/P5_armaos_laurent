package com.safetynet.safetynetalert.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/childAlert")
public class ChildAlertController {

	@GetMapping
	public @ResponseBody String childAlert(@RequestParam("address") String personAddress) {
		
		return personAddress;
	}
}
