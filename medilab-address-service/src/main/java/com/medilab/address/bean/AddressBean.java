/**
 * 
 */
package com.medilab.address.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * @author nsanda
 *
 */
@Data
public class AddressBean implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int addId;
	private String address;
	private String country;
	private String city;
	private String state_province;
	private String postalCode;

}
