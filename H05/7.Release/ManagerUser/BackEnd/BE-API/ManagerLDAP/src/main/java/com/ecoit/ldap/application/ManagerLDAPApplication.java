package com.ecoit.ldap.application;

import com.ecoit.ldap.api.LdapResource;
import com.ecoit.ldap.api.OrganizationResource;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author dorem
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/ldap",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=ManagerLDAP.Rest",
		"auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true"
	},
	service = Application.class
)
@ApplicationPath("/app")
public class ManagerLDAPApplication extends Application {
	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<Object>();
		singletons.add(new JacksonJsonProvider());
		singletons.add(LdapResource.getInstance());
		singletons.add(OrganizationResource.getInstance());
		return singletons;
	}
}