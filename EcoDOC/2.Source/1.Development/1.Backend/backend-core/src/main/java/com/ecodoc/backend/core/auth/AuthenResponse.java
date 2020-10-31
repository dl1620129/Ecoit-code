package com.ecodoc.backend.core.auth;

import java.util.List;

import com.ecodoc.backend.core.domain.Module;
import com.ecodoc.backend.core.domain.Token;
import com.ecodoc.backend.core.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenResponse {
	private Token tokenInfo;
	private User userInfo;
	private List<Module> moduleList;
}
