package com.safetynet.safetynetalert.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalert.domain.dtos.MedicationDto;
import com.safetynet.safetynetalert.service.MedicalRecordService;

@RestController
@RequestMapping("/medicalrecord")
public class MedicalRecordController {
	
	private final MedicalRecordService service;

	public MedicalRecordController(MedicalRecordService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public @ResponseBody MedicationDto createMedicalRecord() {
		
		return service.createMedicalRecord();
	}
	
	@PutMapping("/update")
	public @ResponseBody MedicationDto updateMedicalRecord(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		
		return service.updateMedicalRecord(firstName, lastName);
	}
	
	@DeleteMapping("/delete")
	public @ResponseBody MedicationDto deleteMedicalRecord(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		
		return service.deleteMedicalRecord(firstName, lastName);
	}

}
