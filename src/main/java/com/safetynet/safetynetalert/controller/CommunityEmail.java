package com.safetynet.safetynetalert.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/communityEmail")
public class CommunityEmail {
	
	@GetMapping
	public @ResponseBody String getEmails(@RequestParam("city") String city) {
		
		return city;
	}

}
