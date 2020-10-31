package com.auth.token;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class Token {
	String token;

	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

//	static long seconds = 3 * 60; // 3 minutes
	static ObjectMapper mapper = new ObjectMapper();

	public static String createJWT(long ttlMillis, String data, String user) {
		try {
			TokenObject object = new Token.TokenObject();
			object.setId(UUID.randomUUID().toString());
			object.setData(data);
			object.setUser(user);

			long nowMillis = System.currentTimeMillis();
			Date now = new Date(nowMillis);

			object.setDateAt(now.getTime());

			if (ttlMillis >= 0) {
				long expMillis = nowMillis + ttlMillis;
				Date exp = new Date(expMillis);
				object.setDateEx(exp.getTime());
			}
			String dataw = mapper.writeValueAsString(object);
			String encryptedString = Base64.getEncoder()
					.encodeToString(AsymmetricCryptography.encrypt(dataw, AsymmetricCryptography.publicKey));
			return encryptedString;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static int verifyJWT(String jwt) {
		try {
			String decryptedString = AsymmetricCryptography.decrypt(jwt, AsymmetricCryptography.privateKey);
			if (decryptedString.isEmpty()) {
				return -1;
			}
			TokenObject readValue = mapper.readValue(decryptedString, Token.TokenObject.class);
			long nowMillis = System.currentTimeMillis();

			if (readValue.getDateEx() < nowMillis) {
				return -2;
			}
			return 1;
		} catch (Exception e) {
			return -1;
		}

	}

	public static Token.TokenObject decodeJWT(String jwt) {
		try {
			String decryptedString = AsymmetricCryptography.decrypt(jwt, AsymmetricCryptography.privateKey);
			if (decryptedString.isEmpty()) {
				return null;
			}
			TokenObject readValue = mapper.readValue(decryptedString, Token.TokenObject.class);
			long nowMillis = System.currentTimeMillis();

			if (readValue.getDateEx() < nowMillis) {
				return null;
			}

			return readValue;
		} catch (Exception e) {
			return null;
		}

	}

	public static class TokenObject {
		String id;
		String data;
		long dateAt = 0;
		String user;
		long dateEx = 0;

		public long getDateEx() {
			return dateEx;
		}

		public void setDateEx(long dateEx) {
			this.dateEx = dateEx;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public long getDateAt() {
			return dateAt;
		}

		public void setDateAt(long dateAt) {
			this.dateAt = dateAt;
		}

		public TokenObject() {
			super();
			// TODO Auto-generated constructor stub
		}

	}

}
