package com.medilab.department.service;

import java.util.List;

import com.medilab.department.bean.DepartmentBean;

public interface DepartmentService {

	public DepartmentBean save(DepartmentBean deptBean);
	public DepartmentBean findById(int id);
	public DepartmentBean findByName(String name);
	public List<DepartmentBean> findAll();
	
	public List<DepartmentBean> delete(int id);
	public List<DepartmentBean> delete(DepartmentBean deptBean);
}
