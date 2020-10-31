package com.ecodoc.backend.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.auth.UserLogin;
import com.ecodoc.backend.core.domain.User;

@Service
public class AuthenService implements UserDetailsService{

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userService.findByUserNameAndActive(userName, true);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}
		return new UserLogin(user);
	}
}
