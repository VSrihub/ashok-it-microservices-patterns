package com.medilab.doctor.service;

import java.util.List;

import com.medilab.doctor.bean.DoctorBean;

public interface DoctorService {

	public DoctorBean save(DoctorBean deptBean, String bearerToken);
	public DoctorBean findById(int id);
	public DoctorBean findByName(String name);
	public List<DoctorBean> findAll();
	
	public List<DoctorBean> delete(int id);
	public List<DoctorBean> delete(DoctorBean deptBean);
}
