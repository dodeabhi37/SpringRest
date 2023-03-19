package com.nit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentOperationsController {

	@GetMapping("/report/{sno1}/{sname}")
	public String getReportData(@PathVariable("sno1") int no, @PathVariable String sname) {
		return no + "...." + sname;
	}
}
