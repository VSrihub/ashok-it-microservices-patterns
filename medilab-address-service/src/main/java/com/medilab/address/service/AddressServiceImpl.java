/**
 * 
 */
package com.medilab.address.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medilab.address.bean.AddressBean;
import com.medilab.address.domain.Address;
import com.medilab.address.repo.AddressRepo;

/**
 * @author nsanda
 *
 */
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepo repo;
	
	/* (non-Javadoc)
	 * @see com.medilab.Address.service.AddressService#save(com.medilab.Address.bean.AddressBean)
	 */
	@Override
	public AddressBean save(AddressBean addrBean) {
		Address addrEntity = new Address();
		BeanUtils.copyProperties(addrBean, addrEntity);
		repo.save(addrEntity);
		System.out.println("*******Address saved success fully:\t"+addrEntity.getAddId());
		addrBean.setAddId(addrEntity.getAddId());
		BeanUtils.copyProperties(addrEntity, addrBean);
		
		return addrBean;
	}

	/* (non-Javadoc)
	 * @see com.medilab.Address.service.AddressService#findById(int)
	 */
	@Override
	public AddressBean findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.medilab.Address.service.AddressService#findByName(java.lang.String)
	 */
	@Override
	public AddressBean findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.medilab.Address.service.AddressService#findAll()
	 */
	@Override
	public List<AddressBean> findAll() {
		List<Address> addrList = repo.findAll();
		List<AddressBean> addrBeanList = new ArrayList<>();
		if(addrList != null && addrList.size() >0) {
			addrList.forEach(addrEntity->{
				AddressBean addrBean = new AddressBean();
				BeanUtils.copyProperties(addrEntity, addrBean);
				addrBeanList.add(addrBean);
			});
		}
		return addrBeanList;
	}

	/* (non-Javadoc)
	 * @see com.medilab.Address.service.AddressService#delete(int)
	 */
	@Override
	public List<AddressBean> delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.medilab.Address.service.AddressService#delete(com.medilab.Address.bean.AddressBean)
	 */
	@Override
	public List<AddressBean> delete(AddressBean addrBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
