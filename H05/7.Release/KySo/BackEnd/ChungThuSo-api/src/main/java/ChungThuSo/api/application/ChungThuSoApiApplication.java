package ChungThuSo.api.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import ChungThuSo.api.api.ChungThuSoApi;

/**
 * @author Admin
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/kyso",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Kyso.Rest",
		"auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
	},
	service = Application.class
)
@ApplicationPath("/app")
public class ChungThuSoApiApplication extends Application {

	@Override
    public Set<Object> getSingletons() {
          Set<Object> singletons = new HashSet<Object>();
          singletons.add(new JacksonJsonProvider());
          
         
          singletons.add(ChungThuSoApi.getInstance());
        
          return singletons;
	}

}