package com.ecoit.mr.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.ecoit.mr.api.MemberReportHistoryResource;
import com.ecoit.mr.api.MemberReportResource;
import com.ecoit.mr.api.PermissionResource;
import com.ecoit.mr.api.UnitResource;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/memberreport",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=MemberReport.Rest", "auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true" }, service = Application.class)
@ApplicationPath("/app")
public class MemberReportApplication extends Application {
	@Override
	public Set<Object> getSingletons() {

		Set<Object> singletons = new HashSet<Object>();
		singletons.add(new JacksonJsonProvider());

		// add REST endpoints
		singletons.add(MemberReportResource.getInstance());
		singletons.add(PermissionResource.getInstance());
		singletons.add(UnitResource.getInstance());
		singletons.add(MemberReportHistoryResource.getInstance());
		return singletons;
	}
}
