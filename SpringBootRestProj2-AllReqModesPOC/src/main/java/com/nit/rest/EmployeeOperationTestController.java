package com.nit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationTestController {
	
	@GetMapping("/report")
	public ResponseEntity<String> getAllEmployee(){
		System.out.println("EmployeeOperationTestController.getAllEmployee()");
		return new ResponseEntity<String>("GET-All Employee are Listed",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerEmployee(){
		System.out.println("EmployeeOperationTestController.registerEmployee()");
		return new ResponseEntity<String>("Post- Employee Register",HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(){
		System.out.println("EmployeeOperationTestController.updateEmployee()");
		return new ResponseEntity<String>("PUT- Emplyee is updated ",HttpStatus.OK);
	}
	
	@PatchMapping("/emailUpdate")
	public ResponseEntity<String> updateEmployeeEmail(){
		System.out.println("EmployeeOperationTestController.updateEmployeeEmail()");
		return new ResponseEntity<String>("Patch- Emplyee email is updated ",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(){
		System.out.println("EmployeeOperationTestController.deleteEmployee()");
		return new ResponseEntity<String>("Delete- Emplyee is deleted ",HttpStatus.OK);
	}
	
}
