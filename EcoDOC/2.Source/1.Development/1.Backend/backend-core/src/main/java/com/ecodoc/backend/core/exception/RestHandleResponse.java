package com.ecodoc.backend.core.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestControllerAdvice
public class RestHandleResponse implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}


	@Override
	public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (body instanceof Resource) {
			return body;
		}
		String exceptionMes = "";
		try {
			HttpServletResponse servletResponse = ((ServletServerHttpResponse) response).getServletResponse();
			return new RestResponse(servletResponse.getStatus(), body);
		} catch (Exception e) {
			exceptionMes = e.getMessage();
			log.error("ResponseModel error: " + e);
		}
		return new RestResponse(RestResponse.INTERNAL_SERVER_ERROR, exceptionMes);
	}

}
