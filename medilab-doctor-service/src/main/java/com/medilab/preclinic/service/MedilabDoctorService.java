/**
 * 
 */
package com.medilab.preclinic.service;

import java.util.List;

import com.medilab.preclinic.bean.DoctorBean;

/**
 * @author nsanda
 *
 */
public interface MedilabDoctorService {

	public DoctorBean save(DoctorBean deptBean);
	public List<DoctorBean> findAll();
	public DoctorBean findById(int id);
	public DoctorBean findByName(String name);
	public List<DoctorBean> delete(int id);
	public List<DoctorBean> delete(DoctorBean deptBean);
	public DoctorBean update(DoctorBean deptBean);
	
}
