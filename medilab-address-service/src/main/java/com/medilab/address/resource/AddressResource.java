/**
 * 
 */
package com.medilab.address.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilab.address.bean.AddressBean;
import com.medilab.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author nsanda
 *
 */
@RestController
//@RequestMapping("/api")
@Slf4j
public class AddressResource {

	@Autowired
	private AddressService addrService;

	@PostMapping("/mediplab-addr")
	public ResponseEntity<AddressBean> saveAddress(@RequestBody AddressBean addrBean)  {
		addrBean = addrService.save(addrBean);
		return ResponseEntity.status(HttpStatus.CREATED).body(addrBean);
	}

	@PutMapping("/mediplab-addr")
	public ResponseEntity<AddressBean> updateAddress(@RequestBody AddressBean addrBean) {
		addrBean = addrService.save(addrBean);
		return ResponseEntity.status(HttpStatus.OK).body(addrBean);
	}

	@GetMapping("/mediplab-addr")
	public ResponseEntity<List<AddressBean>> getAllAddresss() {
		List<AddressBean> addrBeanList = addrService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(addrBeanList);
	}

	@GetMapping("/mediplab-addr/{addrId}")
	public ResponseEntity<AddressBean> getAddressById(@PathVariable("addrId") String addrId) {
		AddressBean addrBean = addrService.findById(Integer.valueOf(addrId));
		return ResponseEntity.status(HttpStatus.OK).body(addrBean);
	}

	@DeleteMapping("/mediplab-addr/{addrId}")
	public ResponseEntity<List<AddressBean>> deleteAddress(@PathVariable("addrId") String addrId) {
		List<AddressBean> addrBeanList = addrService.delete(Integer.valueOf(addrId));
		return ResponseEntity.status(HttpStatus.OK).body(addrBeanList);
	}
}
