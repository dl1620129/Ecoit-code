package com.auth.token;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.security.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class AsymmetricCryptography {
	public static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqZJgh0doWTSwBVS5fQq2O82ddtNA6su3KP/JQy0FTyigpXHdLD2clcQCw0J+iILKk4cG/Sj2KZbv+RXr/jX6qryvidIWWaxEbnfyTB6O7PzqwyusQwQ5tA4y9s/EVi05T4XeoR4wBkkWCCKUkMrQjDdUNPWXudD59gi2gEHHCWC0gOYxB5CSxi9Y0o6ms4G3exv69qS4SVVXmyRzSNOOXJT1qXeCIbwnepdbuSzH5VT8+Pt8hD7jIuZP7wVeTeDiLFIKepahNDTKbNj2qttFt8nGa+epfPvR08bZeDlixkoUOLXxynWYpMExdPguM5iULE6J5JzkhbWabAg1roCMowIDAQAB";
	public static String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCpkmCHR2hZNLAFVLl9CrY7zZ1200Dqy7co/8lDLQVPKKClcd0sPZyVxALDQn6IgsqThwb9KPYplu/5Fev+NfqqvK+J0hZZrERud/JMHo7s/OrDK6xDBDm0DjL2z8RWLTlPhd6hHjAGSRYIIpSQytCMN1Q09Ze50Pn2CLaAQccJYLSA5jEHkJLGL1jSjqazgbd7G/r2pLhJVVebJHNI045clPWpd4IhvCd6l1u5LMflVPz4+3yEPuMi5k/vBV5N4OIsUgp6lqE0NMps2Paq20W3ycZr56l8+9HTxtl4OWLGShQ4tfHKdZikwTF0+C4zmJQsTonknOSFtZpsCDWugIyjAgMBAAECggEAGcidDtTHxBCj1xur3Jx9WxiHoeK7UzhIkF5cTu+QiBnIW3+1vp1bqtYUCXaZ4M3qWYZFhMburyI5OOmhaZTxmXZ5Rn6AUYBFI3rvh6151AUc+TIxzjrdP0iNbUPoOaZEuZfEY0FA0iPYysHfTyjXjwp2rlrNiD6DU2q9vUDDL+SZDCSU1khTGTAqPpymsYU7btQTNIGwfY0tjGgELSfgnJi94jgB+/FQDGtlh6lxJOJIVfqbrZQPT9+L0HqrxBMWGyY3PD0jJmCC56e/wP54873dHNJaY4Fa76HkOSibZLjANVZ5x56lbyoPHcTPNCwHDcvKv1VcwQQaPg2tYvRheQKBgQD5OytDNWOUmsfT5a5+hpydEB/XYB8Qd4Lfu2Vcd8pSUe/mhUsAK8HUG2cIv/NeZLEcmFY+Iq7Qvx3R3DmlleDHGwVXJ3D6dL8RoOZjVArefrWZJo5YOzsbswm0q6YxIyN7/zJPBrHxtC9K+KVt+YQBBBSLFAX1UW2XL4MX1hRFpQKBgQCuLVwozvxt2ysCJMeQV/QBKcVXcOOaiCBU8kexcJGt/WfGv4YII/sYuofZ2BXCbr++kBigOqzLxRmnqiyKYXRzYinHK+Ig1r5dnm8VhDpgIIYkG5CsfEFa7dNrrSKHiTNC9SLBkIB/ThgfeGUEYfiKlMvMIBjYll58E+gC7oxGpwKBgQDzunNSZHGfr8XfaOu9/DJIPq6E1xFJ7zXjScWUKemHm216B7wSzLfej3WxTtXW5610g11DonNG3L9yrWUKk4mf7MLKOl338BeyS6FCXbvLXiqFPPlTO4lQS0QglQQPZYecCTLPqYJ3FnhxXruY0rvOqojUgZ5aC2mawfH3a3mjqQKBgDDExp8uhYOE8F/jSHVkCxAgT/8RvsjQAK2IQQavzDp5T4tYqQCygmYEJHGcjUspk0qaMir7AtLzVyGZBmugqeh8vdHkuaYUOq0f5V6S7X1o3eZSSYniKLJ7EM1/ZsGoas/+r0KfYTtD9IErRq2ZeOvkicOX4R0TzVTUhgv8Gw7VAoGBANxxUR5S3+BZV9m5CC1P5gvEq8ZCgtJKCdDSKNL7VOvBYqALUQ7TWyGRCur1vqJzggKmrpea0s1Yb8WlWjyQvtxiRIZqLpEw729TJwgpnX/Y4ereobadA8ZqcxBFaQtuDdvzTxieh8K4KLjF9h8u8ws3DEPKZRZrkyienD1yhBvn";

	public static PublicKey getPublicKey(String base64PublicKey) {
		PublicKey publicKey = null;
		try {
			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.getBytes()));
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			publicKey = keyFactory.generatePublic(keySpec);
			return publicKey;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return publicKey;
	}

	public static PrivateKey getPrivateKey(String base64PrivateKey) {
		PrivateKey privateKey = null;
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(base64PrivateKey.getBytes()));
		KeyFactory keyFactory = null;
		try {
			keyFactory = KeyFactory.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			privateKey = keyFactory.generatePrivate(keySpec);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return privateKey;
	}

	public static byte[] encrypt(String data, String publicKey) throws BadPaddingException, IllegalBlockSizeException,
			InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(publicKey));
		return cipher.doFinal(data.getBytes());
	}

	public static String decrypt(byte[] data, PrivateKey privateKey) throws NoSuchPaddingException,
			NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return new String(cipher.doFinal(data));
	}

	public static String decrypt(String data, String base64PrivateKey) throws IllegalBlockSizeException,
			InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		return decrypt(Base64.getDecoder().decode(data.getBytes()), getPrivateKey(base64PrivateKey));
	}

	public static void main(String[] args)
			throws IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, BadPaddingException {
		try {
			String encryptedString = Base64.getEncoder().encodeToString(encrypt("Dhiraj is the author", publicKey));
			System.out.println(encryptedString);
			String decryptedString = AsymmetricCryptography.decrypt(encryptedString, privateKey);
			System.out.println(decryptedString);
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e.getMessage());
		}

	}

	public static class RSAKeyPairGenerator {

		private PrivateKey privateKey;
		private PublicKey publicKey;

		public RSAKeyPairGenerator() throws NoSuchAlgorithmException {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
			keyGen.initialize(2048);
			KeyPair pair = keyGen.generateKeyPair();
			this.privateKey = pair.getPrivate();
			this.publicKey = pair.getPublic();
		}

		public PrivateKey getPrivateKey() {
			return privateKey;
		}

		public PublicKey getPublicKey() {
			return publicKey;
		}

		public static void main(String[] args) throws NoSuchAlgorithmException {
			RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();
			System.out.println(String.format("Public Key : %s",
					Base64.getEncoder().encodeToString(keyPairGenerator.getPublicKey().getEncoded())));
			System.out.println(String.format("Private Key : %s",
					Base64.getEncoder().encodeToString(keyPairGenerator.getPrivateKey().getEncoded())));
		}
	}

}
