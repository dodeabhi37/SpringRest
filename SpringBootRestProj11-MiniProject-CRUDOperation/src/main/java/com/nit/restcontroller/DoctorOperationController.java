package com.nit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/report")
	public ResponseEntity<?> showAllDoctor(){
		try {
				List<Doctor> list=service.getAllDoctor();
				return new ResponseEntity<List<Doctor>>(list,HttpStatus.OK);
		}catch (Exception e) {
				return new ResponseEntity<String>("Problem in getting records",HttpStatus.INTERNAL_SERVER_ERROR);
				}
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> fetchDocById(@PathVariable("id") int docid){
		try {
			return new ResponseEntity<Doctor>(service.getDoctorById(docid),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> modifyDoctroInfo(@RequestBody Doctor doc){
		try {
			String msg=service.updateDoctor(doc);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		try{
			String msg=service.deleteDoctorById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteByIncome/{start}/{stop}")
	public ResponseEntity<String> deleteByIncomeRange(@PathVariable double start,@PathVariable double stop){
		try {
			System.out.println(start);
			System.out.println(stop);
			
			return new ResponseEntity<String>(service.deleteDoctorsByIncomeRange(start, stop),HttpStatus.OK);
		}catch (Exception e) { 
			throw e;
		}
	}
	
	@PatchMapping("/updateIncome/{id}/{percentage}")
	public ResponseEntity<String> updateIncomeOfDoctor(@PathVariable int id,@PathVariable double percentage){
		try {
			String msg=service.hikeDoctorIncomeByPercentage(id, percentage);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
