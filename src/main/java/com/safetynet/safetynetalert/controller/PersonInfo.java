package com.safetynet.safetynetalert.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personInfo")
public class PersonInfo {

	@GetMapping
	public @ResponseBody String personInfo(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		
		return (firstName + " " + lastName);
	}
}
