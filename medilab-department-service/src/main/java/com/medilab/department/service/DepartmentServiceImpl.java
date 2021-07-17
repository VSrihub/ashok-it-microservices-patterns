/**
 * 
 */
package com.medilab.department.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medilab.department.bean.DepartmentBean;
import com.medilab.department.domain.Department;
import com.medilab.department.repo.DepartmentRepo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author nsanda
 *
 */
@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo repo;
	
	/* (non-Javadoc)
	 * @see com.medilab.department.service.DepartmentService#save(com.medilab.department.bean.DepartmentBean)
	 */
	@Override
	public DepartmentBean save(DepartmentBean deptBean) {
		log.info("department service bean data is:\t"+deptBean.toString());
		Department deptEntity = new Department();
		BeanUtils.copyProperties(deptBean, deptEntity);
		repo.save(deptEntity);
		log.info("department service model data is:\t"+deptEntity.toString());
		BeanUtils.copyProperties(deptEntity, deptBean);
		
		return deptBean;
	}

	/* (non-Javadoc)
	 * @see com.medilab.department.service.DepartmentService#findById(int)
	 */
	@Override
	public DepartmentBean findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.medilab.department.service.DepartmentService#findByName(java.lang.String)
	 */
	@Override
	public DepartmentBean findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.medilab.department.service.DepartmentService#findAll()
	 */
	@Override
	public List<DepartmentBean> findAll() {
		List<Department> deptList = repo.findAll();
		List<DepartmentBean> deptBeanList = new ArrayList<>();
		if(deptList != null && deptList.size() >0) {
			deptList.forEach(deptEntity->{
				DepartmentBean deptBean = new DepartmentBean();
				BeanUtils.copyProperties(deptEntity, deptBean);
				deptBeanList.add(deptBean);
			});
		}
		return deptBeanList;
	}

	/* (non-Javadoc)
	 * @see com.medilab.department.service.DepartmentService#delete(int)
	 */
	@Override
	public List<DepartmentBean> delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.medilab.department.service.DepartmentService#delete(com.medilab.department.bean.DepartmentBean)
	 */
	@Override
	public List<DepartmentBean> delete(DepartmentBean deptBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
