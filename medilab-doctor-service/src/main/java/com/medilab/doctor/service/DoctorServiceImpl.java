/**
 * 
 */
package com.medilab.doctor.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transaction;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medilab.doctor.bean.DoctorBean;
import com.medilab.doctor.domain.Doctor;
import com.medilab.doctor.outbound.AddressServiceClient;
import com.medilab.doctor.repo.DoctorRepo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author nsanda
 *
 */
@Service
@Slf4j
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepo repo;

	@Autowired
	private AddressServiceClient addrClient;
	
	
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.Doctor.service.DoctorService#save(com.medilab.Doctor.bean.
	 * DoctorBean)
	 */
	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED,
	propagation=Propagation.REQUIRED,
	rollbackFor=Exception.class)
	public DoctorBean save(DoctorBean doctBean, String bearerToken) {
		
		Doctor doctEntity = new Doctor();
		BeanUtils.copyProperties(doctBean, doctEntity);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String address = mapper.writeValueAsString(doctBean.getCommAdderss());
			log.info("the address data is:\t" + address);
			
			Map<String,String> headerMap = new HashMap<String,String>();
			headerMap.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
			headerMap.put("Authorization", bearerToken);
			
			log.info("saving throiugh rhe first save methods");
			//repo.save(doctEntity);
			
			ResponseEntity<String> addrResp = addrClient.postAddress(headerMap,address);
			System.out.println("response code is:\t"+addrResp.getStatusCodeValue());
			if(addrResp.getStatusCodeValue() == 201) {
				String postedAddress = addrResp.getBody();
				log.info("address resp is:\t"+postedAddress);
				doctEntity.setCommAdderss(postedAddress);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		log.info("saving throiugh rhe second save methods");
        repo.save(doctEntity);

		BeanUtils.copyProperties(doctEntity, doctBean);

		return doctBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.Doctor.service.DoctorService#findById(int)
	 */
	@Override
	public DoctorBean findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.Doctor.service.DoctorService#findByName(java.lang.String)
	 */
	@Override
	public DoctorBean findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.Doctor.service.DoctorService#findAll()
	 */
	@Override
	public List<DoctorBean> findAll() {
		List<Doctor> doctList = repo.findAll();
		List<DoctorBean> doctBeanList = new ArrayList<>();
		if (doctList != null && doctList.size() > 0) {
			doctList.forEach(doctEntity -> {
				DoctorBean doctBean = new DoctorBean();
				BeanUtils.copyProperties(doctEntity, doctBean);
				doctBeanList.add(doctBean);
			});
		}
		return doctBeanList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.Doctor.service.DoctorService#delete(int)
	 */
	@Override
	public List<DoctorBean> delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medilab.Doctor.service.DoctorService#delete(com.medilab.Doctor.bean.
	 * DoctorBean)
	 */
	@Override
	public List<DoctorBean> delete(DoctorBean doctBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
