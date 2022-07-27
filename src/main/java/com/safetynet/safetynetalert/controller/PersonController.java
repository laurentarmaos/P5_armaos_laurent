package com.safetynet.safetynetalert.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalert.domain.dtos.PersonCreate;
import com.safetynet.safetynetalert.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private final PersonService service;

	public PersonController(PersonService service) {
		this.service = service;
	}


	@PostMapping("/create")
	public JSONArray createPerson(@RequestBody PersonCreate dto) {
		
		return service.createPerson(dto);
	}
	
	@GetMapping("/get")
	public @ResponseBody JSONObject getPerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		
		return service.getPerson(firstName, lastName);
	}
	
	@PutMapping("/update")
	public @ResponseBody JSONArray updatePerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestBody PersonCreate dto) {
		
		return service.updatePerson(firstName, lastName, dto);
	}
	
	@DeleteMapping("/delete")
	public @ResponseBody JSONArray deletePerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		
		return service.deletePerson(firstName, lastName);
	}
}
