package com.medilab.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class MedilabDoctorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedilabDoctorServiceApplication.class, args);
	}

	@Bean
	public JedisConnectionFactory redisConnection() {
		RedisStandaloneConfiguration conf = new RedisStandaloneConfiguration();
		return new JedisConnectionFactory(conf);
	}
	
	@Bean
	public RedisTemplate<String, String>  redisTemplate(){
		RedisTemplate<String, String> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnection());
		return template;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
