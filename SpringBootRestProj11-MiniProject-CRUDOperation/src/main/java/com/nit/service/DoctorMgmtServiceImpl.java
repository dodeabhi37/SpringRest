package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nit.entity.Doctor;
import com.nit.exception.DoctorNotFoundException;
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


	/*@Override
	public List<Doctor> getAllDoctor() {
		List<Doctor> list=docRepo.findAll();
		return list;
	}*/
	
	@Override
	public List<Doctor> getAllDoctor() {
		List<Doctor> list=docRepo.findAll();
		list.sort((s1,s2)->s1.getDocName().compareToIgnoreCase(s2.getDocName()));
		return list;
	}


	@Override
	/*public Doctor getDoctorById(int id) {
		Doctor doc=docRepo.findById(id).get();
		return doc;
	}*/
	
	public Doctor getDoctorById(int id) throws DoctorNotFoundException {
		Doctor doc=docRepo.findById(id).orElseThrow(()-> new DoctorNotFoundException(id+"is not found"));
		return doc;
	}


	@Override
	public String updateDoctor(Doctor doctor) throws DoctorNotFoundException {
		Optional<Doctor> opt=docRepo.findById(doctor.getDocId());
		if(opt.isPresent()) {
			docRepo.save(doctor);
			return doctor.getDocId()+" is updated";
		}else {
			throw new DoctorNotFoundException(doctor.getDocId()+" id is not found");
		}
	}


	@Override
	public String deleteDoctorById(int id) throws DoctorNotFoundException {
		Optional opt=docRepo.findById(id);
		if(opt.isPresent()) {
			docRepo.deleteById(id);
			return id+" id doctro is deleted";
		}else {
			throw new DoctorNotFoundException(id+" id doctor is not found");
		}
		
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String deleteDoctorsByIncomeRange(double start, double end) {
		System.out.println("hello");
		int noOfrecords=docRepo.deleteByIncomeRange(start, end);
		System.out.println(noOfrecords);
		return noOfrecords+" no of records are deleted";
	}


	@Override
	public String hikeDoctorIncomeByPercentage(int id, double percentage) throws DoctorNotFoundException {
		Optional<Doctor> opt=docRepo.findById(id);
		Doctor doc=opt.get();
		if(opt.isPresent()) {
			double salary=doc.getIncome();
			double updated=salary*(1+(double)(percentage/100));
			doc.setIncome(updated);
			docRepo.save(doc);
			return "Doctor income hiked by"+doc.getIncome();
			
		}else {
			throw new DoctorNotFoundException("Doctor not found of id: "+id);
		}
		
	}

}
