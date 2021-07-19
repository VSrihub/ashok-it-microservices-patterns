package com.medilab.preclinic.util;

import java.util.logging.Logger;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="medilab-department-service", url="localhost:5001")
@FeignClient(name="medilab-department-service")
public interface DepartmentFeignClient {
	Logger logger = Logger.getLogger(DepartmentFeignClient.class.getName());

	@GetMapping("/api/departments/{deptId}")
	public ResponseEntity<String> getDepartmentDetails(@PathVariable("deptId") String deptId);

}
