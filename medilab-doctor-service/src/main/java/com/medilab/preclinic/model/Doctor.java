/**
 * 
 */
package com.medilab.preclinic.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * @author nsanda
 *
 */
@Entity
@Data
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1839672696590120994L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int doctId;
	private String fname;
	private String lname;
	private String userId;
	private String email;
	private String password;
	private String cpassword;
	private String dob;
	private String gender;
	private String status;
	private String phone;
	private String avatar;
	private String biography;
	
	@Column(name="DepartmentDetails")
	private String deptInfo;
	
	

}
