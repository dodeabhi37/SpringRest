package com.nit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentOperationsController {
	
	@GetMapping("/report")
	public String getReportData(@RequestParam("sno1") int no,@RequestParam("sname") String name) {
		return no+"...."+name;
	}
}
