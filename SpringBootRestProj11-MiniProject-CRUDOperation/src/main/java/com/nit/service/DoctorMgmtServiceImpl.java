package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Doctor;
import com.nit.repository.IDoctorRepo;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {
	@Autowired
	private IDoctorRepo docRepo;
	

	@Override
	public String registerDoctor(Doctor doc) {
		int idVal=docRepo.save(doc).getDocId();
		return "Doctor object save in db with id value "+idVal;
	}

}
