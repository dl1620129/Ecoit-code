package com.auth.application;

import com.auth.api.AuthResource;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;


/**
 * @author oh
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/auth",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Auth.Rest",
		"auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
	},
	service = Application.class
)
@ApplicationPath("/app")
public class AuthAppApplication extends Application {

	@Override
    public Set<Object> getSingletons() {
		
          Set<Object> singletons = new HashSet<Object>();
          singletons.add(new JacksonJsonProvider());
          
          // add REST endpoints
          singletons.add(AuthResource.getInstance());
          return singletons;
	}

	

}