package com.safetynet.safetynetalert.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.safetynet.safetynetalert.service.PersonInfoService;

@RestController
@RequestMapping("/personInfo")
public class PersonInfoController {

	
	private final PersonInfoService service;
	
	public PersonInfoController(PersonInfoService service) {
		this.service = service;
	}
	
	
	@GetMapping
	public @ResponseBody void personInfo(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		
		service.personInfo(firstName, lastName);

	}
}
