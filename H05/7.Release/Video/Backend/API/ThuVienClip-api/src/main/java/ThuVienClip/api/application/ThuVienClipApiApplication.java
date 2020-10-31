package ThuVienClip.api.application;

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

import ThuVienClip.api.Resource.CategoryResource;
import ThuVienClip.api.Resource.ClipResource;





/**
 * @author Admin
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/clip",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Clip.Rest",
		"auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
	},
	service = Application.class
)
@ApplicationPath("/app")
public class ThuVienClipApiApplication extends Application {

	@Override
    public Set<Object> getSingletons() {
		
          Set<Object> singletons = new HashSet<Object>();
          singletons.add(new JacksonJsonProvider());
          
          // add REST endpoints
          singletons.add(ClipResource.getInstance());
          
          singletons.add(CategoryResource.getInstance());
          return singletons;
	}

	
}