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

import com.safetynet.safetynetalert.domain.dtos.MedicalRecordsCreate;
import com.safetynet.safetynetalert.service.MedicalRecordService;

@RestController
@RequestMapping("/medicalrecord")
public class MedicalRecordController {
	
	private final MedicalRecordService service;

	public MedicalRecordController(MedicalRecordService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public @ResponseBody JSONArray createMedicalRecord(@RequestBody MedicalRecordsCreate dto) {
		
		return service.createMedicalRecord(dto);
	}
	
	@GetMapping("/get")
	public @ResponseBody JSONObject getMedicalRecord(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		return service.getMedicalRecord(firstName, lastName);
	}
	
	@PutMapping("/update")
	public @ResponseBody JSONObject updateMedicalRecord(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		
		return service.updateMedicalRecord(firstName, lastName);
	}
	
	@DeleteMapping("/delete")
	public @ResponseBody JSONObject deleteMedicalRecord(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		
		return service.deleteMedicalRecord(firstName, lastName);
	}

}
