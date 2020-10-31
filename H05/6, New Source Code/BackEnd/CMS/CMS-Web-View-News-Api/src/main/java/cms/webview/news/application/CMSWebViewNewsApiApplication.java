package cms.webview.news.application;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import cms.webview.news.api.DetailResource;
import cms.webview.news.api.FeaturedNewResource;
import cms.webview.news.api.NewResource;
import cms.webview.news.api.SearchNewResource;

/**
 * @author luyentv
 */
@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/news",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=News.Rest", "auth.verifier.guest.allowed=true",
		"liferay.access.control.disable=true" }, service = Application.class)
@ApplicationPath("/app")
public class CMSWebViewNewsApiApplication extends Application {

	public Set<Object> getSingletons() {
		Set<Object> singletons = new HashSet<Object>();

		singletons.add(new JacksonJsonProvider());
		singletons.add(new NewResource());
		singletons.add(new FeaturedNewResource());
		singletons.add(new SearchNewResource());
		singletons.add(new DetailResource());
		return singletons;
	}

}