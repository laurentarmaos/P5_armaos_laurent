package com.safetynet.safetynetalert.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalert.service.CommunityEmailService;

@RestController
@RequestMapping("/communityEmail")
public class CommunityEmailController {
	
	private final CommunityEmailService service;
	
	public CommunityEmailController(CommunityEmailService service) {
		this.service = service;
	}
	
	@GetMapping
	public @ResponseBody void getEmails(@RequestParam("city") String city) {
		
		service.emailCity(city);
		
	}

}
