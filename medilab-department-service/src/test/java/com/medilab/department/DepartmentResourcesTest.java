package com.medilab.department;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medilab.department.bean.DepartmentBean;

@ActiveProfiles(value="stage")
public class DepartmentResourcesTest extends MedilabDepartmentServiceApplicationTests {

	@LocalServerPort
    private int port;
	
	@Autowired
	private RestTemplate rt;
	
	DepartmentBean deptBean = null;
	ObjectMapper mapper = null;
	
	private String getRootUrl() {
        return "http://localhost:" + port+"/api/mediplab-department";
    }
	
	@BeforeEach
	public void setup() {
		deptBean = new DepartmentBean();
		mapper = new ObjectMapper();
	}
	
	@Test
	public void testSaveDept() throws JsonProcessingException {
		deptBean.setName("opthomology");
		deptBean.setDescription("opthomology");
		deptBean.setStatus(true);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        System.out.println("root url is:\t"+getRootUrl());
        
		ResponseEntity<DepartmentBean> response = rt.postForEntity(getRootUrl(), deptBean, 
				DepartmentBean.class,entity);
		System.out.println("status code is:\t"+response.getStatusCodeValue());
		assertEquals(201, response.getStatusCodeValue());
		System.out.println("response is:\t"+response.getBody().getDeptId());
		assertNotNull(response.getBody().getDeptId());
		
	}
	
}
