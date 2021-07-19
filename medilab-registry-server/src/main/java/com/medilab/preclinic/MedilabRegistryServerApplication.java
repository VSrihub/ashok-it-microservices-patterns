package com.medilab.preclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MedilabRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedilabRegistryServerApplication.class, args);
	}

}
