package com.medilab.gateway;

import java.util.Base64;

public interface Auth0IdpConstants {

	String AUTH0_CLIENT_ID = "security.oauth2.client.clientId";
	String AUTH0_CLIENT_SECRET = "security.oauth2.client.client-secret";
	String AUTH0_APPLICATION_SCOPE= "security.oauth2.client.scope";
	String AUTH0_APPLICATION_GRANT_TYPE = "security.oauth2.client.grant-type";
	String AUTH0_TOKEN_URI = "security.oauth2.client.access-token-uri";
	String APP_TOKEN_TYPE="Bearer ";
	String USER_TOKEN_TYPE="Basic ";
	String APP_TOKEN_HEADER_NAME ="Authorization";
	String USER_TOKEN_CONTENT_TYPE_NAME="Content-Type";
	
	public static String generateAppToken(String clientId, String secret) {
		String appTokenHash = clientId+":"+secret;
		appTokenHash = Base64.getEncoder().encodeToString(appTokenHash.getBytes());
		return USER_TOKEN_TYPE+appTokenHash;
	}
	
	public static String getUserTokenBody(String username, String password, String scope, String grantType) {
		StringBuilder str = new StringBuilder();
		str.append("{");
		str.append("    \"username\":\""+username+"\",");
		str.append("    \"password\":\""+password+"\",");
		str.append("\"scope\":\""+scope+"\",");
		str.append("\"grant_type\":\""+grantType+"\"");
		str.append("}");
		
		return str.toString();
	}
}

