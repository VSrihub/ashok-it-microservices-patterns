/**
 * 
 */
package com.medilab.preclinic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medilab.preclinic.bean.DepartmentBean;
import com.medilab.preclinic.exception.DepartmentCreationException;
import com.medilab.preclinic.exception.DepartmentNotFound;
import com.medilab.preclinic.model.Department;
import com.medilab.preclinic.repo.DepartmentRepo;

/**
 * @author nsanda
 *
 */
@Service
public class MedilabDepartmentServiceImpl implements MedilabDepartmentService {

	private static final Logger LOGGER = LogManager.getLogger(MedilabDepartmentServiceImpl.class);
	
	@Autowired
	private DepartmentRepo deptRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.preclinic.service.MedilabDepartmentService#save(com.medilab.
	 * preclinic.bean.DepartmentBean)
	 */
	@Override
	public DepartmentBean save(DepartmentBean deptBean) throws DepartmentCreationException {
		LOGGER.info("save department method");
		Department deptModel = new Department();

		LOGGER.info("copying Bean to Model started...");
		try {
			BeanUtils.copyProperties(deptBean, deptModel);
			LOGGER.info("copying Bean to Model completed...");
			LOGGER.info("saving the department model to the database");
			deptRepo.save(deptModel);
			LOGGER.info("department model saved to the  database");
			BeanUtils.copyProperties(deptModel, deptBean);

			return deptBean;
		}catch (Exception e) {
			throw new DepartmentCreationException(e.getMessage());
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.preclinic.service.MedilabDepartmentService#findAll()
	 */
	@Override
	public List<DepartmentBean> findAll() {
		List<Department> deptModelList = deptRepo.findAll();
		List<DepartmentBean> deptBeanList = new ArrayList<>();
		if (deptModelList != null && deptModelList.size() > 0) {
			deptModelList.stream().forEach(deptModel -> {
				DepartmentBean deptBean = new DepartmentBean();
				BeanUtils.copyProperties(deptModel, deptBean);
				deptBeanList.add(deptBean);
			});
		}
		return deptBeanList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.preclinic.service.MedilabDepartmentService#findById(int)
	 */
	@Override
	public DepartmentBean findById(int id) throws DepartmentNotFound {
		Optional<Department> deptOpt = deptRepo.findById(id);
		if(deptOpt.isPresent()) {
			DepartmentBean deptBean = new DepartmentBean();
			
			Department deptModel = deptOpt.get();
			BeanUtils.copyProperties(deptModel, deptBean);
			return deptBean;
		}else {
			throw new DepartmentNotFound("No Department Found with the Department Id:\t"+id);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.medilab.preclinic.service.MedilabDepartmentService#findByName(java.lang.
	 * String)
	 */
	@Override
	public DepartmentBean findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.preclinic.service.MedilabDepartmentService#delete(int)
	 */
	@Override
	public List<DepartmentBean> delete(int id) {
		deptRepo.deleteById(id);
		return findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.medilab.preclinic.service.MedilabDepartmentService#delete(com.medilab.
	 * preclinic.bean.DepartmentBean)
	 */
	@Override
	public List<DepartmentBean> delete(DepartmentBean deptBean) {
		Department department = new Department();
		BeanUtils.copyProperties(deptBean, department);
		deptRepo.delete(department);
		return findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.medilab.preclinic.service.MedilabDepartmentService#update(com.medilab.
	 * preclinic.bean.DepartmentBean)
	 */
	@Override
	public DepartmentBean update(DepartmentBean deptBean) {
		Department deptModel = new Department();

		BeanUtils.copyProperties(deptBean, deptModel);
		deptRepo.save(deptModel);

		BeanUtils.copyProperties(deptModel, deptBean);
		
		return deptBean;
	}

}
