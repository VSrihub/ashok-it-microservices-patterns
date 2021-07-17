/**
 * 
 */
package com.medilab.department.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilab.department.bean.DepartmentBean;
import com.medilab.department.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author nsanda
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders="*")
@Slf4j
public class DepartmentResource {

	@Autowired
	private DepartmentService deptService;

	@PostMapping("/mediplab-department")
	public ResponseEntity<DepartmentBean> saveUser(@RequestBody DepartmentBean deptBean)  {
		log.info("department bean data is:\t"+deptBean.toString());
		deptBean = deptService.save(deptBean);
		return ResponseEntity.status(HttpStatus.CREATED).body(deptBean);
	}

	@PutMapping("/mediplab-department")
	public ResponseEntity<DepartmentBean> updateUser(@RequestBody DepartmentBean deptBean) {
		deptBean = deptService.save(deptBean);
		return ResponseEntity.status(HttpStatus.OK).body(deptBean);
	}

	@GetMapping("/mediplab-department")
	public ResponseEntity<List<DepartmentBean>> getAllUsers() {
		List<DepartmentBean> deptBeanList = deptService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(deptBeanList);
	}

	@GetMapping("/mediplab-department/{deptId}")
	public ResponseEntity<DepartmentBean> getUserById(@PathVariable("deptId") String deptId) {
		DepartmentBean deptBean = deptService.findById(Integer.valueOf(deptId));
		return ResponseEntity.status(HttpStatus.OK).body(deptBean);
	}

	@DeleteMapping("/mediplab-department/{deptId}")
	public ResponseEntity<List<DepartmentBean>> deleteUser(@PathVariable("deptId") String deptId) {
		List<DepartmentBean> deptBeanList = deptService.delete(Integer.valueOf(deptId));
		return ResponseEntity.status(HttpStatus.OK).body(deptBeanList);
	}
}
