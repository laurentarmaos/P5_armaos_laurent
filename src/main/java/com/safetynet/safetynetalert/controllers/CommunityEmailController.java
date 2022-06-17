package com.safetynet.safetynetalert.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/communityEmail")
public class CommunityEmailController {
	
	@GetMapping
	public @ResponseBody String getEmails(@RequestParam("city") String city) {
		
		
		return city;
	}

}
