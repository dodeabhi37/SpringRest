package com.nit.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Doctor;
import com.nit.service.IDoctorMgmtService;

@RestController
@RequestMapping("/doctor")
public class DoctorOperationController {
	@Autowired
	private IDoctorMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerDoctor(@RequestBody Doctor doc){
		String message=service.registerDoctor(doc);
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
}
