package com.medilab.authn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medilab.authn.idp.Auth0IdpClient;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders="*")
public class IdpTokenResorce {

	@Autowired
	private Auth0IdpClient idpClient;
	
	@PostMapping("/token")
	public String getIdpToken(@RequestBody UserAuthnBean authnBean) {
		return idpClient.idpUserAuthn(authnBean.getUsername(), authnBean.getPassword());
	}
}
