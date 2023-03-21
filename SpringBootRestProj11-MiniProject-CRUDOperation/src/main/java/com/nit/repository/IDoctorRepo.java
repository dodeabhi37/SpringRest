package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	
	@Modifying
	@Query("DELETE FROM Doctor WHERE income>=:start AND income<=:stop") //it i HQL query written on base of entity class
	public int deleteByIncomeRange(double start,double stop);
}
