package com.medilab.preclinic.resource;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilab.preclinic.bean.DoctorBean;
import com.medilab.preclinic.exception.DoctorCreationException;
import com.medilab.preclinic.exception.DoctorNotFound;
import com.medilab.preclinic.service.MedilabDoctorService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class DoctorController {

	@Autowired
	private MedilabDoctorService deptService;
	
	/*
	 * @Value("${medilab.doctorFee}") private String doctorFee;
	 */
	//@RequestMapping(value="/Doctors",method=RequestMethod.GET)
	@GetMapping("/Doctors")
	public List<DoctorBean> viewDoctorsBoard() {
		log.info("i am in Doctors");
		
		List<DoctorBean> deptBeanList = deptService.findAll();
		
		return deptBeanList;
	}
	
	//@RequestMapping(value="/Doctors/{deptId}",method=RequestMethod.GET)
	@GetMapping("/Doctors/{doctId}")
	public ResponseEntity<Object> getDoctor(@PathVariable("doctId") int doctId) throws DoctorNotFound {
		log.info("doctor id is:\t"+doctId);
		//log.info("the consultaion fee of the doctor is {}",doctorFee);
		//try {
			DoctorBean deptBean = deptService.findById(doctId);
			//deptBean.setConsultFee(Double.valueOf(doctorFee));
			return ResponseEntity.ok(deptBean);
		/*} catch (DoctorNotFound e) {
			ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), 
					e.getMessage(), 
					new Date(), 
					e.getMessage()) ;
			return ResponseEntity.ok(error);
		}*/
	}
	
	//addDept
	//@RequestMapping(value="/Doctors",method=RequestMethod.POST)
	@PostMapping(value="/Doctors")
	//@CircuitBreaker(name = "addDoctorCiruit",fallbackMethod="addDoctFallback")
	//@Retry(name="addDoctorRetry",fallbackMethod="addDoctFallback")
	@RateLimiter(name="addDoctorRateLimiter",fallbackMethod="addDoctFallback")
	public List<DoctorBean> addDept(@Valid @RequestBody DoctorBean deptbean) {
		log.info("deptbean data is:\t"+deptbean.toString());
		deptbean = deptService.save(deptbean);
		List<DoctorBean> deptBeanList = deptService.findAll();
	
		return deptBeanList;
	}
	
	public List<DoctorBean> addDoctFallback(DoctorBean deptbean, Throwable t){
		log.info("fall back metod deptbean data is:\t"+deptbean.toString());
		List<DoctorBean> deptBeanList = new ArrayList<DoctorBean>();
		/*
		 * deptbean = deptService.save(deptbean); /List<DoctorBean> deptBeanList =
		 * deptService.findAll();
		 * 
		 * //secondary store //deptbean = new DoctorBean();
		 */		deptbean.setDept("No Department available due to the dept service down");
		deptBeanList.add(deptbean);
		return deptBeanList;
	}
	
	//@RequestMapping(value="/Doctors/{deptId}",method=RequestMethod.DELETE)
	@DeleteMapping("/Doctors/{deptId}")
	public List<DoctorBean> deleteDoctor(@PathVariable("deptId") int deptId) {
		log.info("deprtment id is:\t"+deptId);
		
		List<DoctorBean> deptBeanList = deptService.delete(deptId);
		return deptBeanList;
	}
	
	/*@RequestMapping("/editDept/{deptId}")
	public String editDoctorPage(@PathVariable("deptId") int deptId,Model model) {
		log.info("deprtment id is:\t"+deptId);
		DoctorBean deptBean = deptService.findById(deptId);
		model.addAttribute("deptBean", deptBean);
		return "Doctor/editDoctors";
	}*/
	
	//@RequestMapping(value="/Doctors",method=RequestMethod.PUT)
	@PutMapping("/Doctors")
	public List<DoctorBean> updateDept(@RequestBody DoctorBean deptbean) throws DoctorCreationException {
		log.info("updateDept data is:\t"+deptbean.toString());
		deptbean = deptService.save(deptbean);
		
		List<DoctorBean> deptBeanList = deptService.findAll();
		return deptBeanList;
	}
}
