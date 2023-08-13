package com.ApplicationRegi.ARModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ApplicationRegi.ARModule.payloads.CitizenApp;
import com.ApplicationRegi.ARModule.service.serviceimpl.ArService;

@RestController
public class ArRestController {
	
	@Autowired
	private ArService arService;
	
	@PostMapping("/app")
	public ResponseEntity<String> createCitizenApp(@RequestBody CitizenApp app)
	{
		
	Integer status=arService.createApplication(app);
	
	if (status>0) {
		
		return new ResponseEntity<>("App Created with App Id:"+status,HttpStatus.OK);
		
	}
	else {
		
		return new ResponseEntity<String>("App Not created With this Id"+status,HttpStatus.BAD_REQUEST);
	}
		
	}
}
