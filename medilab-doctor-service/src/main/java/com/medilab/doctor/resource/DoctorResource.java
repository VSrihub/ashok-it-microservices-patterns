/**
 * 
 */
package com.medilab.doctor.resource;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
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

import com.medilab.doctor.bean.DoctorBean;
import com.medilab.doctor.service.DoctorService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author nsanda
 *
 */
@RestController
@RefreshScope
//@RequestMapping("/api")
@Slf4j
public class DoctorResource {

	@Autowired
	private DoctorService doctService;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	/*@Value("${doctor.fee}")
	private String docFee;*/

	@PostMapping("/mediplab-doctor")
	public ResponseEntity<DoctorBean> saveUser(@RequestBody DoctorBean doctBean, HttpServletRequest request, HttpServletResponse resp)  {
		String tokenWithBearer = request.getHeader("Authorization");
		if(tokenWithBearer == null || tokenWithBearer.isEmpty()) {
			HashOperations hashOps = redisTemplate.opsForHash();
			String tokenWithoutBearer = (String) hashOps.get("x-Authorization", "Bearer");
			tokenWithBearer = "Bearer "+tokenWithoutBearer;
			log.info("token with bearer extracted from cache is:\t"+tokenWithBearer);
		}
		log.info("in doctor service i.e. in resource token extracted is:\t"+tokenWithBearer);
		doctBean = doctService.save(doctBean,tokenWithBearer);
		return ResponseEntity.status(HttpStatus.CREATED).body(doctBean);
	}

	@PutMapping("/mediplab-doctor")
	public ResponseEntity<DoctorBean> updateUser(@RequestBody DoctorBean doctBean,HttpServletRequest request) {
		String tokenWithBearer = request.getHeader("Authorization");
		doctBean = doctService.save(doctBean, tokenWithBearer);
		return ResponseEntity.status(HttpStatus.OK).body(doctBean);
	}

	@GetMapping("/mediplab-doctor")
	public ResponseEntity<List<DoctorBean>> getAllUsers() {
		//log.info("doctor fee is:\t "+docFee);
		List<DoctorBean> doctBeanList = doctService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(doctBeanList);
	}

	@GetMapping("/mediplab-doctor/{doctId}")
	public ResponseEntity<DoctorBean> getUserById(@PathVariable("doctId") String doctId) {
		DoctorBean doctBean = doctService.findById(Integer.valueOf(doctId));
		return ResponseEntity.status(HttpStatus.OK).body(doctBean);
	}

	@DeleteMapping("/mediplab-doctor/{doctId}")
	public ResponseEntity<List<DoctorBean>> deleteUser(@PathVariable("doctId") String doctId) {
		List<DoctorBean> doctBeanList = doctService.delete(Integer.valueOf(doctId));
		return ResponseEntity.status(HttpStatus.OK).body(doctBeanList);
	}
}
