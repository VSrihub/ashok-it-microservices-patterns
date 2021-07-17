package com.medilab.address.service;

import java.util.List;

import com.medilab.address.bean.AddressBean;

public interface AddressService {

	public AddressBean save(AddressBean deptBean);
	public AddressBean findById(int id);
	public AddressBean findByName(String name);
	public List<AddressBean> findAll();
	
	public List<AddressBean> delete(int id);
	public List<AddressBean> delete(AddressBean deptBean);
}
