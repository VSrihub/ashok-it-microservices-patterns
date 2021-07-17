/**
 * 
 */
package com.medilab.department.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author nsanda
 *
 */
@Entity
@Data
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int deptId;
	
	@Column(unique=true,nullable=false)
	private String name;
	
	private String description;
	
	@Column(nullable=false)
	private boolean status;

}
