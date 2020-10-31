package com.ecodoc.backend.core.auth;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.domain.Token;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author EcoDOC
 * 
 */
@Component
@Slf4j
public class TokenHelper {

	private final String SECRET_KEY = "DOC#2020";

	private final long TIME_EXPIRE = 2592000000L;// Millisecond

	/**
	 * Generate token from user name logged
	 * 
	 * @param userName
	 * @return
	 */
	public Token generateToken(String userName) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + TIME_EXPIRE);
		String tokenValue = Jwts.builder().setSubject(userName).setIssuedAt(now).setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
		Token tokenInfo = new Token(tokenValue, expiryDate);
		return tokenInfo;
	}

	/**
	 * Generate token client
	 * 
	 * @param createDate is day that client is use system
	 * @return
	 */
	public String generateExpire(Date createDate) {
		Date start = createDate == null ? new Date() : createDate;
		Date expiryDate = new Date(start.getTime() + TIME_EXPIRE);
		String tokenValue = Jwts.builder().setSubject("Expire date").setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
		Token tokenInfo = new Token(tokenValue, expiryDate);
		return tokenInfo.getAccessToken();
	}

	/**
	 * Generate token client
	 * 
	 * @param clientName
	 * @param timeStamp
	 * @return
	 */
	public boolean checkExpireClient(String token) {
		try {
			if (StringUtils.isNullOrEmpty(token))
				return false;
			Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
			if (claims == null || claims.getExpiration() == null)
				return false;
			if (System.currentTimeMillis() < claims.getExpiration().getTime())
				return true;
			return false;
		} catch (Exception e) {
			throw new RestExceptionHandler(Message.CLIENT_EXPIRE);
		}
	}

	/**
	 * Get user name from subject of JWT Token
	 * 
	 * @param token
	 * @return
	 */
	public String getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken);
			return true;
		} catch (MalformedJwtException ex) {
			log.error("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			log.error("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			log.error("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			log.error("JWT claims string is empty.");
		}
		return false;
	}
}