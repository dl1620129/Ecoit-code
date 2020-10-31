package com.ecodoc.backend.util;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtils {

	private static final String DEFAULT_PW = "123456";

	public static String encode(PasswordEncoder encoder, String key) {
		String value = encoder.encode(key);
		return value;
	}

	public static String getDefaultPassword(PasswordEncoder encoder) {
		return encode(encoder, DEFAULT_PW);
	}

	public static String getPasswordEncode(PasswordEncoder encoder,String password) {
		return encode(encoder, password);
	}

	public static boolean matches(PasswordEncoder encoder, CharSequence rawPassword, String encodedPassword) {
		boolean isMactch = encoder.matches(rawPassword, encodedPassword);
		return isMactch;
	}

}
