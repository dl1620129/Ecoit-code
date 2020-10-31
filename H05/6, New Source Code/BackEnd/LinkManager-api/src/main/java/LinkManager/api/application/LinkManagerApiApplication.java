package LinkManager.api.application;

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

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import LinkManager.api.resource.GroupLinkResource;
import LinkManager.api.resource.LinkResource;

/**
 * @author Admin
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/link",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Links.Rest",
		"auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
	},
	service = Application.class
)
@ApplicationPath("/app")
public class LinkManagerApiApplication extends Application {


	@Override
    public Set<Object> getSingletons() {
		
          Set<Object> singletons = new HashSet<Object>();
          singletons.add(new JacksonJsonProvider());
          
          // add REST endpoints
          singletons.add(LinkResource.getInstance());
          
          singletons.add(GroupLinkResource.getInstance());
          return singletons;
	}



}