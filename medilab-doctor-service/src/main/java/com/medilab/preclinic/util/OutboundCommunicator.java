package com.medilab.preclinic.util;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public interface OutboundCommunicator {
	Logger logger = Logger.getLogger(OutboundCommunicator.class.getName());

	String DEPARTMENT_API_BASE_URL = "http://localhost:5001/api/departments/";

	public static String getDepartmentDetails(String deptId) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> getDeptResp = rt.getForEntity(DEPARTMENT_API_BASE_URL + deptId, String.class);
		if (getDeptResp != null) {
			int statusCode = getDeptResp.getStatusCodeValue();
			logger.info("get department by id status code is:\t" + statusCode);
			String deptResp = getDeptResp.getBody();
			logger.info("get department by id responde data is:\t" + deptResp);
			if (statusCode == HttpStatus.OK.value() && !deptResp.contains("code")) {
				return deptResp;
			}

		}
		return null;
	}

}
