package elegal.application;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import elegal.api.ELegalResource;
import elegal.api.OrganizationResource;
import elegal.api.PermissionResource;
import elegal.api.SuggestResource;

/**
 * @author oh
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/elegal",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=ELegalDocument.Rest", "auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true" }, service = Application.class)
@ApplicationPath("/app")
public class ELegalDocumentAppApplication extends Application {
	@Override
	public Set<Object> getSingletons() {

		Set<Object> singletons = new HashSet<Object>();
		singletons.add(new JacksonJsonProvider());

		// add REST endpoints
		singletons.add(ELegalResource.getInstance());
		singletons.add(PermissionResource.getInstance());
		singletons.add(OrganizationResource.getInstance());
		singletons.add(SuggestResource.getInstance());
		return singletons;
	}

}