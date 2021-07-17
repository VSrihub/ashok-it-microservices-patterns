package com.medilab.doctor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import com.medilab.doctor.bean.DoctorAddressBean;
import com.medilab.doctor.bean.DoctorBean;

@ActiveProfiles(value = "stage")
public class MedilabDoctorIntegrationTest extends MedilabDoctorServiceApplicationTests {

	private static final String AUTHORIZATION_TOKEN = "ixOTN5c2zIb2WyzX3_r80nVVzHCMbsXR";
	DoctorBean doctBean = null;
	DoctorAddressBean doctAdddress = null;

	public String getServiceurl() {
		return "http://localhost:" + port + "/mediplab-doctor";
	}

	@LocalServerPort
	private int port;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RedisTemplate redisTemplate;

	@BeforeEach
	public void setUp() {
		doctBean = new DoctorBean();
		doctAdddress = new DoctorAddressBean();
		doctAdddress.setAddress("hyd");
		doctAdddress.setCity("Hderabad");
		doctAdddress.setCountry("India");
		doctAdddress.setPostalCode("500074");
		doctAdddress.setState_province("TS");
	}

	@Test
	public void testDoctorRegistration() {
		doctBean.setFname("John");
		doctBean.setLname("Doe");
		doctBean.setEmail("johnd@email.com");
		doctBean.setUserId("johnd");
		doctBean.setPassword("test");
		doctBean.setCpassword("test");
		doctBean.setGender("Male");
		doctBean.setPhone("0987654321");
		doctBean.setStatus(true);
		doctBean.setCommAdderss(doctAdddress);

		HashOperations hashOps = redisTemplate.opsForHash();
		hashOps.putIfAbsent("x-Authorization", "Bearer", AUTHORIZATION_TOKEN);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Authorization", "Bearer " + AUTHORIZATION_TOKEN);

		HttpEntity entity = new HttpEntity<>(headers);
		
		ResponseEntity<DoctorBean> resp = restTemplate.postForEntity(getServiceurl(), doctBean, DoctorBean.class,entity);
		System.out.println("doctor data is:\t"+resp.getBody().toString());
		System.out.println("address data is:\t"+resp.getBody().getCommAdderss().toString());
		assertNotNull(resp);
		assertEquals(201, resp.getStatusCodeValue());
		assertNotNull(resp.getBody());
		assertNotNull(resp.getBody().getDoctId());
		assertNotNull(resp.getBody().getCommAdderss().getAddId());
		
		
	}
}
