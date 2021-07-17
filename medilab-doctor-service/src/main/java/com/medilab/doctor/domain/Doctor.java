/**
 * 
 */
package com.medilab.doctor.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nsanda
 *
 */
@Entity
@Data
@NoArgsConstructor
public class Doctor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int doctId;
	
	@Column(nullable=false)
	private String fname;
	private String lname;
	
	@Column(nullable=false,unique=true)
	private String userId;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	private String cpassword;
	
	private String dob;
	
	private String gender;
	
	@Column(nullable=false)
	private String phone;
	
	private String commAdderss;
	
	private String biography;
	private boolean status;

}
