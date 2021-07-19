package com.medilab.preclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MedilabConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedilabConfigServerApplication.class, args);
	}

}
