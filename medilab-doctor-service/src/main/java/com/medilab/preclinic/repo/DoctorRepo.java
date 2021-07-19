/**
 * 
 */
package com.medilab.preclinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medilab.preclinic.model.Doctor;

/**
 * @author nsanda
 *
 */
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}
