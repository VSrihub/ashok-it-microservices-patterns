package com.medilab.doctor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medilab.doctor.domain.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

	@Query("from Doctor d where d.email=:email")
	public Doctor findByName(@Param("email") String email);
}
