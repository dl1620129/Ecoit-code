package com.ecoit.lichcongtac.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.ecoit.lichcongtac.api.LichChiTietResource;
import com.ecoit.lichcongtac.api.LichCongTacResource;
import com.ecoit.lichcongtac.api.PermissionResource;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/lichcongtac",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=LichCongTac.Rest", "auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true" }, service = Application.class)
@ApplicationPath("/app")
public class LichCongTacApplication extends Application {
	@Override
	public Set<Object> getSingletons() {

		Set<Object> singletons = new HashSet<Object>();
		singletons.add(new JacksonJsonProvider());

		// add REST endpoints
		singletons.add(LichCongTacResource.getInstance());
		singletons.add(PermissionResource.getInstance());
		singletons.add(LichChiTietResource.getInstance());
		return singletons;
	}
}
