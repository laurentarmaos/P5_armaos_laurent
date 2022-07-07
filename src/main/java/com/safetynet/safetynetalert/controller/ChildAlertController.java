package com.safetynet.safetynetalert.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalert.service.ChildAlertService;

@RestController
@RequestMapping("/childAlert")
public class ChildAlertController {

	private final ChildAlertService service;
	
	
	
	public ChildAlertController(ChildAlertService service) {
		this.service = service;
	}



	@GetMapping
	public @ResponseBody List<Object> childAlert(@RequestParam("address") String personAddress) {
		
		return service.childAlert(personAddress);
	}
}
