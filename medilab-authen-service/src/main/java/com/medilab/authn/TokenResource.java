/**
 * 
 */
package com.medilab.authn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilab.authn.idp.Auth0IdpClient;

/**
 * @author nsanda
 *
 */
@RestController
@EnableOAuth2Sso
@RequestMapping("/oauth")
@CrossOrigin(allowedHeaders="*")
public class TokenResource {

	@Autowired
	private OAuth2ClientContext oauth2Context;
	
	
	
	
	@GetMapping("/token")
	public OAuth2AccessToken getOauthToken() {
		return oauth2Context.getAccessToken();
	}
}
