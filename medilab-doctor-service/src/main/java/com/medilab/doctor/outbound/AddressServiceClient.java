package com.medilab.doctor.outbound;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

//@FeignClient(name="medilab-address-service",url="localhost:9060")
@FeignClient(name="medilab-api-gateway")
public interface AddressServiceClient {

	@PostMapping(value="/api/medilab-address-service/mediplab-addr",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> postAddress(@RequestHeader Map<String,String> headerMap ,
			@RequestBody String addrReq);
		
}
