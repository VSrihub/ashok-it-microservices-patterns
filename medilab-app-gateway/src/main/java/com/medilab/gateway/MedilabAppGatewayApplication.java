package com.medilab.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient

public class MedilabAppGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedilabAppGatewayApplication.class, args);
	}
	
	@Bean
	public GatewayFilter gatewayFilter() {
		return new GatewayFilter();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
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
	
	/*@Bean
	public CorsFilter corsFilter() {
		return new CorsFilter();
	}*/
}
