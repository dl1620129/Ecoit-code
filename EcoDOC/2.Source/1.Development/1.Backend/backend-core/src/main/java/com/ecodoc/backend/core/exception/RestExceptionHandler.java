package com.ecodoc.backend.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

/**
 * @author EcoDOC
 * 
 */
@Slf4j
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestExceptionHandler extends RuntimeException {

	public RestExceptionHandler(String message) {
		super(message);
	}

}
