/**
 * 
 */
package com.medilab.preclinic.bean;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nsanda
 *
 */
@Data
@NoArgsConstructor
public class DepartmentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1839672696590120994L;
	private int deptId;
	
	@NotEmpty(message="Department Name should be entered")
	private String name;
	
	@Size(max=50,message="description of length only 50 characters allowed")
	private String description;
	
	@NotEmpty(message="status should be entered")
	private String status;

}
