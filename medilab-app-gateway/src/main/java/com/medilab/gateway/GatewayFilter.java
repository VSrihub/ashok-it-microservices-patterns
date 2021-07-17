package com.medilab.gateway;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.netflix.zuul.filters.ZuulServletFilter;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(allowedHeaders="*")
@Slf4j
public class GatewayFilter extends ZuulServletFilter {
	
	@Autowired
	private Auth0IdpClient authoIdpClient;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		log.info("i am in shouldFilter filter");
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		String headerVal = request.getHeader("Authorization");
		if(headerVal != null && !headerVal.isEmpty()) {
			if(headerVal.contains("Bearer "))
				headerVal = headerVal.replace("Bearer ", "");
		}else {
			HashOperations hashOps = redisTemplate.opsForHash();
				String tokenWithoutBearer = (String) hashOps.get("x-Authorization", "Bearer");
				headerVal = "Bearer "+tokenWithoutBearer;
				log.info("token with bearer extracted from cache is:\t"+headerVal);

		}
		log.info("header value is:\t"+headerVal);
		if(headerVal != null && !headerVal.isEmpty()) {
			
			String userInfo = authoIdpClient.idpTokenValidation(headerVal);
			if(userInfo != null && !userInfo.isEmpty()) {
				//response.setHeader("Authorization", headerVal);
				HashOperations hashOps = redisTemplate.opsForHash();
				hashOps.putIfAbsent("x-Authorization", "Bearer", headerVal);
				super.doFilter(request, response, filterChain);
			}else {
				HttpServletResponse resp = (HttpServletResponse) servletResponse;
				//resp.setStatus(403);
				resp.sendError(403, "Forbidden");
			}
			
			
		}else {
			log.info("dont forward the request to the underlying microservice");
			HttpServletResponse resp = (HttpServletResponse) servletResponse;
			//resp.setStatus(403);
			resp.sendError(403, "Forbidden");
		}
		
	}

	/*@Override
	public boolean shouldFilter() {
		System.out.println("i am in shouldFilter filter");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("i am in gateway filter");
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		String headerVal = request.getHeader("Authorization");
		if(headerVal != null && !headerVal.isEmpty()) {
			if(headerVal.contains("Bearer "))
				headerVal = headerVal.replace("Bearer ", "");
			
			//make an network call to auth0IDP to validate the token
		}
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre-filter";
	}

	@Override
	public int filterOrder() {
		
		return 0;
	}*/

}
