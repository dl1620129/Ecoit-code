package com.ecodoc.backend.core.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ecodoc.backend.core.auth.TokenHelper;
import com.ecodoc.backend.core.auth.UserLogin;
import com.ecodoc.backend.core.service.AuthenService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author EcoDOC
 */
@Slf4j
public class AuthenticationProvider extends OncePerRequestFilter {
	@Autowired
	private TokenHelper tokenProvider;

	@Autowired
	private AuthenService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			SecurityContextHolder.getContext().setAuthentication(getAuthen(request));
			filterChain.doFilter(request, response);
		} catch (UsernameNotFoundException e) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, Message.NOT_FOUND_USER);
		}
	}

	private UsernamePasswordAuthenticationToken getAuthen(HttpServletRequest request) {
		String kongHeader = request.getHeader("kong");
		if (kongHeader != null) {
			log.info("[Kong] : `{}`", request.getRequestURI());
		}
		log.info("Check filter request");
		String jwt = getJwtFromRequest(request);
		if (!StringUtils.hasText(jwt) || !tokenProvider.validateToken(jwt)) {
			return null;
		}
		String username = tokenProvider.getUserIdFromJWT(jwt);
		UserLogin userDetails = (UserLogin) customUserDetailsService.loadUserByUsername(username);
		if (userDetails == null || StringUtils.isEmpty(userDetails.getUsername())) {
			return null;
		}
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
				userDetails, null, userDetails.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		return authentication;
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		log.info("Token info: " + bearerToken);
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}
}
