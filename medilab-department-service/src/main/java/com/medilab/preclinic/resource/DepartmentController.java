package com.medilab.preclinic.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilab.preclinic.bean.DepartmentBean;
import com.medilab.preclinic.exception.DepartmentCreationException;
import com.medilab.preclinic.exception.DepartmentNotFound;
import com.medilab.preclinic.service.MedilabDepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class DepartmentController {

	@Autowired
	private MedilabDepartmentService deptService;
	
	//@RequestMapping(value="/departments",method=RequestMethod.GET)
	@GetMapping("/departments")
	public List<DepartmentBean> viewDepartmentsBoard() {
		log.info("i am in departments");
		
		List<DepartmentBean> deptBeanList = deptService.findAll();
		
		return deptBeanList;
	}
	
	//@RequestMapping(value="/departments/{deptId}",method=RequestMethod.GET)
	@GetMapping("/departments/{deptId}")
	public ResponseEntity<Object> getDepartment(@PathVariable("deptId") int deptId) throws DepartmentNotFound {
		log.info("deprtment id is:\t"+deptId);
		//try {
			DepartmentBean deptBeanList = deptService.findById(deptId);
			return ResponseEntity.ok(deptBeanList);
		/*} catch (DepartmentNotFound e) {
			ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), 
					e.getMessage(), 
					new Date(), 
					e.getMessage()) ;
			return ResponseEntity.ok(error);
		}*/
	}
	
	//addDept
	//@RequestMapping(value="/departments",method=RequestMethod.POST)
	@PostMapping(value="/departments")
	public List<DepartmentBean> addDept(@Valid @RequestBody DepartmentBean deptbean) throws DepartmentCreationException {
		log.info("deptbean data is:\t"+deptbean.toString());
		deptbean = deptService.save(deptbean);
		List<DepartmentBean> deptBeanList = deptService.findAll();
	
		return deptBeanList;
	}
	
	//@RequestMapping(value="/departments/{deptId}",method=RequestMethod.DELETE)
	@DeleteMapping("/departments/{deptId}")
	public List<DepartmentBean> deleteDepartment(@PathVariable("deptId") int deptId) {
		log.info("deprtment id is:\t"+deptId);
		
		List<DepartmentBean> deptBeanList = deptService.delete(deptId);
		return deptBeanList;
	}
	
	/*@RequestMapping("/editDept/{deptId}")
	public String editDepartmentPage(@PathVariable("deptId") int deptId,Model model) {
		log.info("deprtment id is:\t"+deptId);
		DepartmentBean deptBean = deptService.findById(deptId);
		model.addAttribute("deptBean", deptBean);
		return "department/editDepartments";
	}*/
	
	//@RequestMapping(value="/departments",method=RequestMethod.PUT)
	@PutMapping("/departments")
	public List<DepartmentBean> updateDept(@RequestBody DepartmentBean deptbean) throws DepartmentCreationException {
		log.info("updateDept data is:\t"+deptbean.toString());
		deptbean = deptService.save(deptbean);
		
		List<DepartmentBean> deptBeanList = deptService.findAll();
		return deptBeanList;
	}
}
