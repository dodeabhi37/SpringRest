package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {

}
