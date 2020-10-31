package com.ecoit.elegal.signer.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.ecoit.elegal.signer.api.SignerResource;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/legalsigner",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=LegalSigner.Rest", "auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true" }, service = Application.class)
@ApplicationPath("/app")
public class ELegalSignerAppApplication extends Application {
	
	@Override
	public Set<Object> getSingletons() {

		Set<Object> singletons = new HashSet<Object>();
		singletons.add(new JacksonJsonProvider());

		// add REST endpoints
		singletons.add(SignerResource.getInstance());

		return singletons;
	}
}
