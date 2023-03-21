package com.nit.service;

import java.util.List;

import com.nit.entity.Doctor;
import com.nit.exception.DoctorNotFoundException;

public interface IDoctorMgmtService {
	public String registerDoctor(Doctor doc);
	public List<Doctor> getAllDoctor();
	public Doctor getDoctorById(int id) throws DoctorNotFoundException;
	public String updateDoctor(Doctor doctor) throws DoctorNotFoundException;
	public String deleteDoctorById(int id) throws DoctorNotFoundException;
	public String deleteDoctorsByIncomeRange(double start, double end);
	public String hikeDoctorIncomeByPercentage(int id, double percentage) throws DoctorNotFoundException;
}
