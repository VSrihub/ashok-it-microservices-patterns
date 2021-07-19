/**
 * 
 */
package com.medilab.preclinic.service;

import java.util.List;

import com.medilab.preclinic.bean.DepartmentBean;
import com.medilab.preclinic.exception.DepartmentCreationException;
import com.medilab.preclinic.exception.DepartmentNotFound;

/**
 * @author nsanda
 *
 */
public interface MedilabDepartmentService {

	public DepartmentBean save(DepartmentBean deptBean) throws DepartmentCreationException;
	public List<DepartmentBean> findAll();
	public DepartmentBean findById(int id) throws DepartmentNotFound;
	public DepartmentBean findByName(String name);
	public List<DepartmentBean> delete(int id);
	public List<DepartmentBean> delete(DepartmentBean deptBean);
	public DepartmentBean update(DepartmentBean deptBean);
	
}
