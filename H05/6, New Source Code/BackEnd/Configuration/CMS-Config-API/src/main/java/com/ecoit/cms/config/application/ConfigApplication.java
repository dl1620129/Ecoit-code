package com.ecoit.cms.config.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.ecoit.cms.config.api.ConfigResource;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/cmsconfig",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=CMSConfig.Rest", "auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true" }, service = Application.class)
@ApplicationPath("/app")
public class ConfigApplication extends Application {
	@Override
	public Set<Object> getSingletons() {

		Set<Object> singletons = new HashSet<Object>();
		singletons.add(new JacksonJsonProvider());

		// add REST endpoints
		singletons.add(ConfigResource.getInstance());

		return singletons;
	}
}
