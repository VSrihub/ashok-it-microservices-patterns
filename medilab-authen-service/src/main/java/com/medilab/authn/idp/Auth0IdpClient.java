package com.medilab.authn.idp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Auth0IdpClient {

	@Autowired
	private RestTemplate rt;

	@Autowired
	private Environment env;

	public String idpUserAuthn(String username, String password) {
		String clientId = env.getProperty(Auth0IdpConstants.AUTH0_CLIENT_ID);
		String clientSecret = env.getProperty(Auth0IdpConstants.AUTH0_CLIENT_SECRET);
		String grantType = env.getProperty(Auth0IdpConstants.AUTH0_APPLICATION_GRANT_TYPE);
		String scope = env.getProperty(Auth0IdpConstants.AUTH0_APPLICATION_SCOPE);
		String tokenUri = env.getProperty(Auth0IdpConstants.AUTH0_TOKEN_URI);

		/**
		 * Step-1: Prepare the token with client Id and secret
		 */
		String appToken = Auth0IdpConstants.generateAppToken(clientId, clientSecret);

		/**
		 * Step-2: Prepare the Headers
		 */
		HttpHeaders headers = new HttpHeaders();
		headers.add(Auth0IdpConstants.APP_TOKEN_HEADER_NAME, appToken);
		headers.add(Auth0IdpConstants.USER_TOKEN_CONTENT_TYPE_NAME, MediaType.APPLICATION_JSON_VALUE);
		// HttpEntity<String> headerEntity = new Http

		String userTokenBody = Auth0IdpConstants.getUserTokenBody(username, password, scope, grantType);

		HttpEntity<String> userTokenEntity = new HttpEntity<String>(userTokenBody, headers);
		

		ResponseEntity<String> userTokenResp = rt.postForEntity(tokenUri, userTokenEntity, String.class);
		if (userTokenResp != null && userTokenResp.getStatusCodeValue() == HttpStatus.OK.value()) {
			return userTokenResp.getBody();
		}

		return null;
	}
}
