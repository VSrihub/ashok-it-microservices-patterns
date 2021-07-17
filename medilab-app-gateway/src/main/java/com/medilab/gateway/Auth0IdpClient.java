package com.medilab.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Auth0IdpClient {

	@Autowired
	private RestTemplate rt;

	@Autowired
	private Environment env;

	public String idpTokenValidation(String userToken) {
		String tokenUri = env.getProperty("auth0.user.info.endpoint");

		String clientId = env.getProperty(Auth0IdpConstants.AUTH0_CLIENT_ID);
		String clientSecret = env.getProperty(Auth0IdpConstants.AUTH0_CLIENT_SECRET);
		
		/**
		 * Step-1: Prepare the token with client Id and secret
		 */
		String appToken = Auth0IdpConstants.generateAppToken(clientId, clientSecret);
		/**
		 * Step-2: Prepare the Headers
		 */
		HttpHeaders headers = new HttpHeaders();
		headers.add(Auth0IdpConstants.APP_TOKEN_HEADER_NAME, Auth0IdpConstants.APP_TOKEN_TYPE+userToken);
		
		HttpEntity<String> auth0LoginRequest = new HttpEntity<String>(headers);

		//ResponseEntity<String> userTokenResp = rt.postForEntity(tokenUri, auth0LoginRequest, String.class);
		//ResponseEntity<String> userTokenResp = rt.getForEntity(tokenUri, String.class, auth0LoginRequest);
		try
		{
			ResponseEntity<String> userTokenResp = rt.exchange(tokenUri, HttpMethod.GET, auth0LoginRequest, String.class);
			if (userTokenResp != null) {
				return userTokenResp.getBody();
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		return null;
	}
}
