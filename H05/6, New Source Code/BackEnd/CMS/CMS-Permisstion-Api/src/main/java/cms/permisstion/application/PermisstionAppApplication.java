package cms.permisstion.application;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import cms.permisstion.api.PermisstionResource;

/**
 * @author Admin
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/permission",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Permission.Rest","auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true"
	},
	service = Application.class
)
@ApplicationPath("/app")
public class PermisstionAppApplication extends Application {

	@Override
    public Set<Object> getSingletons() {
		
          Set<Object> singletons = new HashSet<Object>();
          singletons.add(new JacksonJsonProvider());

          //singletons.add(new CorsFilter());
          
          // add REST endpoints
          singletons.add(PermisstionResource.getInstance());
          return singletons;
	}
}