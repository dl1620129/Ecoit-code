package com.ecodoc.backend.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class RestFieldExceptionHandler extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RestFieldExceptionHandler(@NonNull String field, @NonNull String message) {
		super("{\"field\": \"" + field + "\", \"message\": \"" + message + "\"}");
	}
}
