package com.auth.token;

import org.apache.commons.codec.binary.Base64;

public class AuthObject {
	String username;
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String[] decode(final String encoded) {
		final byte[] decodedBytes = Base64.decodeBase64(encoded.getBytes());
		final String pair = new String(decodedBytes);
		final String[] userDetails = pair.split(":", 2);
		return userDetails;
	}

	public static String createEncodedText(final String username, final String password) {
		final String pair = username + ":" + password;
		final byte[] encodedBytes = Base64.encodeBase64(pair.getBytes());
		return new String(encodedBytes);
	}

}
