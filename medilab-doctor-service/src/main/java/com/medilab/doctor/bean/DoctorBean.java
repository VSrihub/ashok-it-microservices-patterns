/**
 * 
 */
package com.medilab.doctor.bean;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nsanda
 *
 */
@Data
@NoArgsConstructor
public class DoctorBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int doctId;
	private String fname;
	private String lname;
	private String userId;
	
	private String email;
	private String password;
	private String cpassword;
	
	private String dob;
	
	private String gender;
	private String phone;
	
	//private String commAdderss;
	private DoctorAddressBean commAdderss;
	
	private String biography;
	private boolean status;

}
